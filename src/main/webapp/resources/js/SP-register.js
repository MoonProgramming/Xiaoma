// Get references to the database service
var dbRef = firebase.database();
var serviceProviderRef = dbRef.ref('spPublic');
var usersRef = dbRef.ref('users');
var user = firebase.auth().currentUser;
var storage = firebase.storage();

// Form Wizard
$(document).ready(function () {
  //Initialize tooltips
  $('.nav-tabs > li a[title]').tooltip();

  //Wizard
  $('a[data-toggle="tab"]').on('show.bs.tab', function (e) {
    var $target = $(e.target);
    if ($target.parent().hasClass('disabled')) {
      return false;
    }
  });

  $(".next-step").click(function (e) {
    var $active = $('.wizard .nav-tabs li.active');
    $active.next().removeClass('disabled');
    nextTab($active);
  });

  $(".prev-step").click(function (e) {
    var $active = $('.wizard .nav-tabs li.active');
    prevTab($active);
  });
});

function nextTab(elem) {
  $(elem).next().find('a[data-toggle="tab"]').click();
}
function prevTab(elem) {
  $(elem).prev().find('a[data-toggle="tab"]').click();
}

// write SP to database
function writeSPData(userId, name, tel, email, address, ic, pwd) {
  firebase.database().ref('spPrivate/' + userId).set({
    
    fullName: name,
    phone: tel,
    email: email,
    address: address,
    icNumber: ic,
    password : pwd,
    role: "serviceProvider"
  })
  .then (function() {
    console.log("SP Information Saved in database:", userId, email);
  })
  .catch(function(error) {
    console.log("Error writing SP data: ", error);
  });
}

// Service Provider Register
$('#doSPRegister').on('click', function (e) {
  e.preventDefault

  $('#messageModalLabel').html('<span class="text-center text-info"><i class="fa fa-cog fa-spin">Registering SP...</i></span>');
  $('#messageModal').modal('show');

  if( $('#sp-input-Email').val() != '' && $('#sp-input-pwd').val() != ''  && $('#sp-reinput-pwd').val() != '' &&
  $('#sp-input-FullName').val() != '' && $('#sp-input-Tel').val() != '' && $('#sp-textarea-homeaddress').val() != '' &&
  $('#sp-input-IC').val() != ''){
    if( $('#sp-input-pwd').val() == $('#sp-reinput-pwd').val() ){
      //create the user
      firebase.auth().createUserWithEmailAndPassword(
        $('#sp-input-Email').val(),
        $('#sp-input-pwd').val())

        .then(function(user){
          console.log("Successfully created SP account with uid:", user.uid, user.email);
          $('#messageModalLabel').html('<span class="text-success">服務員帳戶創建成功！</span>')

          //create reference for icPic storage
            var file = $('#sp-pic-IC').prop('files')[0];
            var icStorageLocation = storage.ref().child('private').child(user.uid + 'IC');
            var icDatabaseLocation = firebase.database().ref('spPrivate/' + user.uid + '/icURL');
            if (file) {
                // call resize function (auto upload)
                resizeImage(file, 600, 600, icStorageLocation, icDatabaseLocation);    
            }
        

          //write SP to database
          writeSPData(user.uid, $("#sp-input-FullName").val(), $('#sp-input-Tel').val(), user.email, $('#sp-textarea-homeaddress').val(), $('#sp-input-IC').val(), $("#sp-input-pwd").val());

          // set timeout, hide the modal automatically
          setTimeout(function () {
            $('#messageModal').modal('hide');
          },2000);

          // Update a user's profile
          // user.updateProfile({
          //   displayName: $("#registerName").val()
          // }).then(function() {
          //   console.log("displayName update successful.");
          // }).catch(function(error) {
          //   console.log("displayName not updated.");
          // });

          // Direct to next tab after register
          var $active = $('.wizard .nav-tabs li.active');
          $active.next().removeClass('disabled');
          nextTab($active);

          //send user email Verification
          user.sendEmailVerification().then(function() {
            // Email sent.
            alert('Email Verification Sent!');
          }).catch(function(error) {
            // An error happened.
            alert('Sending Email Verification Failed! retry at profile page.');
          });
        })

        .catch(function(error, userData) {
          // Handle Errors here.
          //   var errorCode = error.code;
          //   var errorMessage = error.message;
          if (error) {
            console.log("Error creating user:", error);
            $('#messageModalLabel').html('<span class="text-danger">建立帳戶失敗： '+ error.message + '</span>')
          }
        });
    }
    else {
      //password and confirm password didn't match
      $('#messageModalLabel').html('<span class="text-danger">建立帳戶失敗：\'再填密碼\'與\'自定密碼\'不符</span>')
    }
  }
  else {
    //email & password is empty
    $('#messageModalLabel').html('<span class="text-danger">建立帳戶失敗：您提供的資料並不充足</span>')
    $('#messageModal').modal('show');
  }
});

// Service Provider Register-nextstep1
$('#doSPRegister-nextstep1').on('click', function (e) {
  e.preventDefault

  $('#messageModalLabel').html('<span class="text-center text-info"><i class="fa fa-cog fa-spin">更新個人資料...</i></span>');
  $('#messageModal').modal('show');

  if( $('#sp-input-Nickname').val() != '' && $('#sp-select-state').val() != ''  && $('#sp-date-birthdate').val() != '' && $('#checkboxes-0').val() != ''){

    firebase.auth().onAuthStateChanged(function(user) {
      if (user) {

        //update SP database
        firebase.database().ref('spPublic/' + user.uid).update({
          uid: user.uid,
          nickname: $('#sp-input-Nickname').val(),
          state: $('#sp-select-state').val(),
          countryISO: "MY",
          birthdate: $('#sp-date-birthdate').val(),
          language_mandarin: $("#checkboxes-0").prop('checked')? "華語" : "",
          language_cantonese: $("#checkboxes-1").prop('checked')? "粵語" : "",
          language_hakka: $("#checkboxes-2").prop('checked')? "客家語" : "",
          language_hokkien: $("#checkboxes-3").prop('checked')? "福建語" : "",
          language_english: $("#checkboxes-4").prop('checked')? "英語" : "",
          language_malay: $("#checkboxes-5").prop('checked')? "馬來語" : "",
          language_others: $("#language-text-6").val()
        })
        .then (function() {
          console.log("SP data updated");
          $('#messageModalLabel').html('<span class="text-success">服務員帳戶成功更新！</span>')
        })
        .catch(function(error) {
          console.log("Error updating SP to database: ", error);
        });

        // set timeout, hide the modal automatically
        setTimeout(function () {
          $('#messageModal').modal('hide');
        },1000);

        // Update a user's profile
        // user.updateProfile({
        //   displayName: $("#registerName").val(),
        //   displayName: $("#registerName").val(),
        //   displayName: $("#registerName").val(),
        //   displayName: $("#registerName").val()
        // }).then(function() {
        //   console.log("displayName update successful.");
        // }).catch(function(error) {
        //   console.log("displayName not updated.");
        // });

        // Direct to next tab after register
        var $active = $('.wizard .nav-tabs li.active');
        $active.next().removeClass('disabled');
        nextTab($active);
      } else {
        // No user is signed in.
        console.log("No SP is signed in");
        $('#messageModalLabel').html('<span class="text-danger">更新帳戶失敗：服務員未登入</span>')
      }
    });
  }
  else {
    //提供的資料並不充足
    $('#messageModalLabel').html('<span class="text-danger">更新帳戶失敗：您提供的資料並不充足</span>')
    $('#messageModal').modal('show');
  }
});

// Service Provider Register-nextstep2
$('#doSPRegister-nextstep2').on('click', function (e) {
  e.preventDefault

  $('#messageModalLabel').html('<span class="text-center text-info"><i class="fa fa-cog fa-spin">更新個人資料...</i></span>');
  $('#messageModal').modal('show');

  if( $('#sp-number-jobcount').val() != '' && $('#sp-textarea-selfintro').val() != ''){

    firebase.auth().onAuthStateChanged(function(user) {
      if (user) {

        //create reference for galleryPic1 Pic storage
        var file = $('#sp-pic-portrait').prop('files')[0];      
        var galleryStorageLocation = storage.ref().child('public').child(user.uid).child('galleryPic1');
        var galleryDatabaseLocation = firebase.database().ref('spPublic/' + user.uid + '/gallery/' + 'galleryPic1');
          
        if (file) {
            // resize then upload
            resizeImage(file, 720, 720, galleryStorageLocation, galleryDatabaseLocation);    
        }

        //update SP database
        firebase.database().ref('spPublic/' + user.uid).update({
          experience: $('input:radio[name=sp-radio-experience]:checked').val(),
          selfIntro: $('#sp-textarea-selfintro').val(),
          work24hours: $('input:radio[name=sp-radios-24hours]:checked').val(),
          searchable: "true", //edit when launch
            veryfied: true //edit when launch
        })
        .then (function() {
          console.log("SP data updated");
          $('#messageModalLabel').html('<span class="text-success">服務員帳戶成功更新！</span>')
        })
        .catch(function(error) {
          console.log("Error updating SP to database: ", error);
        });

        // set timeout, hide the modal automatically
        setTimeout(function () {
          $('#messageModal').modal('hide');
        },1000);

        // Update a user's profile
        // user.updateProfile({
        //   displayName: $("#registerName").val(),
        //   displayName: $("#registerName").val(),
        //   displayName: $("#registerName").val(),
        //   displayName: $("#registerName").val()
        // }).then(function() {
        //   console.log("displayName update successful.");
        // }).catch(function(error) {
        //   console.log("displayName not updated.");
        // });

        // Direct to next tab after register
        var $active = $('.wizard .nav-tabs li.active');
        $active.next().removeClass('disabled');
        nextTab($active);
      } else {
        // No user is signed in.
        console.log("No SP is signed in");
        $('#messageModalLabel').html('<span class="text-danger">更新帳戶失敗：服務員未登入</span>')
      }
    });
  }
  else {
    //提供的資料並不充足
    $('#messageModalLabel').html('<span class="text-danger">更新帳戶失敗：您提供的資料並不充足</span>')
    $('#messageModal').modal('show');
  }
});

// Upload function: upload IC pic to storage
function uploadToStorage(file, location, userId) {
  // Create the file metadata
  var metadata = {
    contentType: 'image/jpeg'
  };
  // Upload file and metadata to the object 'images/mountains.jpg'
  var uploadTask = location.put(file, metadata);
  // Listen for state changes, errors, and completion of the upload.
  uploadTask.on(firebase.storage.TaskEvent.STATE_CHANGED, // or 'state_changed'
  function(snapshot) {
    // Get task progress, including the number of bytes uploaded and the total number of bytes to be uploaded
    var progress = (snapshot.bytesTransferred / snapshot.totalBytes) * 100;
    console.log('Upload is ' + progress + '% done');
    switch (snapshot.state) {
      case firebase.storage.TaskState.PAUSED: // or 'paused'
      console.log('Upload is paused');
      break;
      case firebase.storage.TaskState.RUNNING: // or 'running'
      console.log('Upload is running');
      break;
    }
  }, function(error) {
    console.log('照片上傳失敗：', error.message);
    // A full list of error codes is available at
    // https://firebase.google.com/docs/storage/web/handle-errors
    switch (error.code) {
      case 'storage/unauthorized':
      // User doesn't have permission to access the object
      break;

      case 'storage/canceled':
      // User canceled the upload
      break;

      case 'storage/unknown':
      // Unknown error occurred, inspect error.serverResponse
      break;
    }
  }, function() {
    console.log('照片成功上傳');
    // Upload completed successfully, now we can get the download URL
    var downloadURL = uploadTask.snapshot.downloadURL;
    // add icURL to database
    firebase.database().ref('spPrivate/' + userId).update({
      icURL: downloadURL
    })
    .then (function() {
      console.log("icURL added to database: ", downloadURL);
    })
    .catch(function(error) {
      console.log("Error adding icURL to database: ", error);
    });
  });
}

// Upload function: upload galleryPic1 pic to storage
function uploadPortraitToStorage(file, location, userId) {
  // Create the file metadata
  var metadata = {
    contentType: 'image/jpeg'
  };
  // Upload file and metadata to the object 'images/mountains.jpg'
  var uploadTask = location.put(file, metadata);
  // Listen for state changes, errors, and completion of the upload.
  uploadTask.on(firebase.storage.TaskEvent.STATE_CHANGED, // or 'state_changed'
  function(snapshot) {
    // Get task progress, including the number of bytes uploaded and the total number of bytes to be uploaded
    var progress = (snapshot.bytesTransferred / snapshot.totalBytes) * 100;
    console.log('Upload is ' + progress + '% done');
    switch (snapshot.state) {
      case firebase.storage.TaskState.PAUSED: // or 'paused'
      console.log('Upload is paused');
      break;
      case firebase.storage.TaskState.RUNNING: // or 'running'
      console.log('Upload is running');
      break;
    }
  }, function(error) {
    console.log('照片上傳失敗：', error.message);
    // A full list of error codes is available at
    // https://firebase.google.com/docs/storage/web/handle-errors
    switch (error.code) {
      case 'storage/unauthorized':
      // User doesn't have permission to access the object
      break;

      case 'storage/canceled':
      // User canceled the upload
      break;

      case 'storage/unknown':
      // Unknown error occurred, inspect error.serverResponse
      break;
    }
  }, function() {
    console.log('照片成功上傳');
    // Upload completed successfully, now we can get the download URL
    var downloadURL = uploadTask.snapshot.downloadURL;
    // add galleryPic1 url to database
    firebase.database().ref('spPublic/' + userId + '/gallery').update({
      galleryPic1: downloadURL
    })
    .then (function() {
      console.log("galleryPic1 added to database: ", downloadURL);
    })
    .catch(function(error) {
      console.log("Error adding galleryPic1 to database: ", error);
    });
  });
}

// resize image
function resizeImage(file, img_width, img_height, storageLocation, databaseLocation) {
    ImageTools.resize(file, {
        width: img_width, // maximum width
        height: img_height // maximum height
    }, function (blob, didItResize) {
        // didItResize will be true if it managed to resize it, otherwise false (and will return the original file as 'blob')
        // show resized picture
        // document.getElementById(field).src = window.URL.createObjectURL(blob);

        // call upload function
        uploadToStorage(blob, storageLocation, databaseLocation);
    });
}

// Upload function: upload pic to storage
function uploadToStorage(file, storageLocation, databaseLocation) {
    // Create the file metadata
    var metadata = {
        contentType: 'image/jpeg'
    };
    // Upload file and metadata to the object 'images/mountains.jpg'
    var uploadTask = storageLocation.put(file, metadata);
    // Listen for state changes, errors, and completion of the upload.
    uploadTask.on(firebase.storage.TaskEvent.STATE_CHANGED, // or 'state_changed'
        function (snapshot) {
            // Get task progress, including the number of bytes uploaded and the total number of bytes to be uploaded
            var progress = (snapshot.bytesTransferred / snapshot.totalBytes) * 100;
            console.log('Upload is ' + progress + '% done');
            switch (snapshot.state) {
                case firebase.storage.TaskState.PAUSED: // or 'paused'
                    console.log('Upload is paused');
                    break;
                case firebase.storage.TaskState.RUNNING: // or 'running'
                    console.log('Upload is running');
                    break;
            }
        },
        function (error) {
            console.log('照片上傳失敗：', error.message);
            // A full list of error codes is available at
            // https://firebase.google.com/docs/storage/web/handle-errors
            switch (error.code) {
                case 'storage/unauthorized':
                    // User doesn't have permission to access the object
                    break;

                case 'storage/canceled':
                    // User canceled the upload
                    break;

                case 'storage/unknown':
                    // Unknown error occurred, inspect error.serverResponse
                    break;
            }
        },
        function () {
            console.log('照片成功上傳');
            // Upload completed successfully, now we can get the download URL
            var downloadURL = uploadTask.snapshot.downloadURL;
            // add gallery URL to database
            databaseLocation.set(downloadURL)
                .then(function () {
                    console.log("Picture added to database: ", downloadURL);
                })
                .catch(function (error) {
                    console.log("Error adding picture to database: ", error);
                });
        });
}


$('#sp-pic-IC').change(function () {

    var file = this.files[0];
    ImageTools.resize(file, {
        width: 600, // maximum width
        height: 600 // maximum height
    }, function (blob, didItResize) {
        // didItResize will be true if it managed to resize it, otherwise false (and will return the original file as 'blob')
        // show resized picture
        document.getElementById('icURL').src = window.URL.createObjectURL(blob);    
    });
});


$('#sp-pic-portrait').change(function () {

    var file = this.files[0];
    ImageTools.resize(file, {
        width: 720, // maximum width
        height: 720 // maximum height
    }, function (blob, didItResize) {
        // didItResize will be true if it managed to resize it, otherwise false (and will return the original file as 'blob')
        // show resized picture
        document.getElementById('galleryPic1').src = window.URL.createObjectURL(blob);    
    });
});


// validate method for IC pic upload
// $.validator.addMethod('filesize', function(value, element, param) {
//     // param = size (en bytes)
//     // element = element to validate (<input>)
//     // value = value of the element (file name)
//     return this.optional(element) || (element.files[0].size <= param)
// });
