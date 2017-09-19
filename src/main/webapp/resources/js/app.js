// Get references to the database service
var dbRef = firebase.database();
var serviceProviderRef = dbRef.ref('spPrivate');
var usersRef = dbRef.ref('users');
var user = firebase.auth().currentUser;
var storage = firebase.storage();


$("#nav-sp-dashboard").hide();


//Firebase sign-in status update: onAuthStateChanged
firebase.auth().onAuthStateChanged(function (user) {

    console.log("onAuthStateChanged triggered");

    if (user) {

        // User is signed in.
        var userId = firebase.auth().currentUser.uid;
        console.log("User:", user.uid, "is signed in", "with email:", user.email);



        // read database private
        //        firebase.database().ref('/spPrivate/' + userId).on('value', function (snapshot) {
        //            console.log(snapshot.val());
        //
        //            // if it is SP, display SP dashboard
        //            if (snapshot.val() != null) {
        //            $("#nav-sp-dashboard").show();
        //            }
        //        });

        $("#nav-sp-dashboard").show();
        $("#nav-signOutButton").show();
        $("#nav-sp-register").hide();
        $("#nav-user-register").hide();
        $("#nav-login").hide();
        // window.location = 'SP-register.html';


        // user.providerData.forEach(function (profile) {
        //   console.log("user.displayName: "+user.displayName);
        //   console.log("user.email: "+user.email);
        //   console.log("user.photoURL: "+user.photoURL);
        //   console.log("user.emailVerified: "+user.emailVerified);
        //   console.log("Sign-in provider: "+profile.providerId);
        //   console.log("  Provider-specific UID: "+profile.uid);
        //   console.log("  profile.displayName: "+profile.displayName);
        //   console.log("  profile.email: "+profile.email);
        //   console.log("  profile.photoURL: "+profile.photoURL);
        // });

        // when 我的帳戶 is pressed
        $('#nav-sp-dashboard').on('click', function (e) {

            // read database private, to check is User or SP
            firebase.database().ref('/spPrivate/' + userId).on('value', function (snapshot) {
                console.log(snapshot.val());

                // if it is SP, direct to SP dashboard
                if (snapshot.val() != null) {
                    $(location).attr('href', '/sp/sp-dashboard.html')
                // if it's user, direct to user-dashboard
                } else {
                    $(location).attr('href', '/sp/user-update.html')
                }
            });
        });


    } else {
        console.log("No user is signed in.");
        $("#nav-sp-dashboard").hide();
        $("#nav-signOutButton").hide();
        $("#nav-sp-register").show();
        $("#nav-user-register").show();
        $("#nav-login").show();
        // $("#signInButton").show();
    }
});



// function, write user to database
function writeUserData(userId, name, phone, email, childBirthdate, address, pwd) {
    firebase.database().ref('users/' + userId).set({
            displayName: name,
            phone: phone,
            email: email,
            childBirthdate: childBirthdate,
            address: address,
            password: pwd,
            role: "user"
        })
        .then(function () {
            console.log("Success writing User data.");
        })
        .catch(function (error) {
            console.log("Error writing User data: ", error);
        });
}


// When doRegister is pressed
$('#doRegister').on('click', function (e) {
    e.preventDefault();
    $('#registerModal').modal('hide');
    $('#messageModalLabel').html('<span class="text-center text-info"><i class="fa fa-cog fa-spin">註冊帳號...</i></span>');
    $('#messageModal').modal('show');

    if ($('#user-input-email').val() != '' && $('#user-textarea-homeaddress').val() != '' && $('#user-text-password').val() != '' && $('#user-text-confirmPassword').val() != '') {
        if ($('#user-text-password').val() == $('#user-text-confirmPassword').val()) {
            //create the user
            firebase.auth().createUserWithEmailAndPassword(
                    $('#user-input-email').val(),
                    $('#user-text-password').val())

                .then(function (user) {
                    console.log("Successfully created user account with uid:", user.uid, user.email);
                    $('#messageModalLabel').html('<span class="text-success">成功建立帳號</span>')

                    //write user to database
                    writeUserData(user.uid, $("#user-input-displayName").val(), $("#user-input-Tel").val(), user.email, $("#user-date-childBirthdate").val(), $("#user-textarea-homeaddress").val(), $("#user-text-password").val());
                    console.log("User Information Saved in database:", user.uid, user.email);
                    setTimeout(function () {
                        $('#messageModal').modal('hide');
                    }, 2000);

                    // Update a user's profile
                    user.updateProfile({
                        displayName: $("#user-input-displayName").val()
                    }).then(function () {
                        console.log("displayName update successful.");
                    }).catch(function (error) {
                        console.log("displayName not updated.", error);
                    });

                    //send user email Verification
                    user.sendEmailVerification().then(function () {
                        // Email sent.
                        alert('Email Verification Sent!');
                    }).catch(function (error) {
                        // An error happened.
                        alert('Sending Email Verification Failed! retry at profile page.');
                    });

                    //direct user to index.html
                    //window.location = '/index.html';
                })

                .catch(function (error, userData) {
                    // Handle Errors here.
                    //   var errorCode = error.code;
                    //   var errorMessage = error.message;
                    if (error) {
                        console.log("Error creating user:", error);
                        $('#messageModalLabel').html('<span class="text-danger">建立帳戶失敗： ' + error.message + '</span>')
                    }
                });
        } else {
            //password and confirm password didn't match
            $('#messageModalLabel').html('<span class="text-danger">建立帳戶失敗：\'再填密碼\'與\'自定密碼\'不符</span>')
        }
    } else {
        //email & password is empty
        $('#messageModalLabel').html('<span class="text-danger">有<span class="glyphicon glyphicon-asterisk" aria-hidden="true"></span> 標誌的必須填寫</span>')
        $('#messageModal').modal('show');
    }
});


// When login Button is pressed
$('#doLogin').on('click', function (e) {
    e.preventDefault();
    $('#loginModal').modal('hide');
    $('#messageModalLabel').html('<span class="text-center text-info"><i class="fa fa-cog fa-spin">Signing In...</i></span>');
    $('#messageModal').modal('show');
    //login the user
    firebase.auth().signInWithEmailAndPassword(
            $('#loginEmail').val(),
            $('#loginPassword').val())
        .then(function (user) {
            console.log('User:', user.uid, 'signed in.');
            $('#messageModalLabel').html('<span class="text-center text-success">Success!</span>')
            setTimeout(function () {
                $('#messageModal').modal('hide');
                $(location).attr('href', '/index.html')
            }, 2000);
        })
        .catch(function (error) {
            // Handle Errors here.
            // var errorCode = error.code;
            // var errorMessage = error.message;
            console.log("Login Failed!", error);
            $('#messageModalLabel').html('<span class="text-danger">ERROR: ' + error.message + '</span>')
        });
});


// when forgotPassword is pressed
$('#doForgetPassword').on('click', function (e) {
    var auth = firebase.auth();
    auth.onAuthStateChanged(function (user) {
        if (user == null) {
            if ($('#pwdResetEmail').val() != '' && user == null) {
                var emailAddress = $('#pwdResetEmail').val();
                auth.sendPasswordResetEmail(emailAddress).then(function () {
                    // Email sent.
                    alert('password reset email Sent! Check your mail to re-login.');
                    $('#forgotPasswordModal').modal('hide');
                }).catch(function (error) {
                    alert('Send password reset email failed!');
                });
            } else {
                alert('Your email cannot be empty!');
            }
        } else {
            alert('Youre already signed in!');
            $(location).attr('href', '/')
        }
    });
});


//sign out function
$('#nav-signOutButton').on('click', function (e) {
    console.log('signout button clicked');
    firebase.auth().signOut().then(function () {
        console.log("Sign-out successful.");
    }).catch(function (error) {
        console.log("error: Sign-out not successful.");
    });
})


// when searchButton is pressed
$('.searchSP').on('click', function (e) {

    $(location).attr('href', '/newSpList.html')

});






// When the window is fully loaded, call this function.
// Note: because we are attaching an event listener to a particular HTML element
// in this function, we can't do that until the HTML element in question has
// been loaded. Otherwise, we're attaching our listener to nothing, and no code
// will run when the submit button is clicked.
// $(window).load(function () {

// Find the HTML element with the id recommendationForm, and when the submit
// event is triggered on that element, call submitRecommendation.
//   $("#writeform").submit(submitServiceProvider);
//     var bornDate = $('#client-date-input').val();
//     $('.client-date-input').val(bornDate);

// });


//Bootstrap tooltips
// $(document).ready(function(){
//     $('[data-toggle="tooltip"]').tooltip();
// });

//Service Worker
// if ('serviceWorker' in navigator) {
//   navigator.serviceWorker
//   .register('./service-worker.js')
//   .then(function() {
//     console.log('Service Worker Registered');
//   });
// }

// document.addEventListener('DOMContentLoaded', function() {
//   // // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥
//   // // The Firebase SDK is initialized and available here!
//   //
//   // firebase.auth().onAuthStateChanged(user => { });
//   // firebase.database().ref('/path/to/ref').on('value', snapshot => { });
//   // firebase.messaging().requestPermission().then(() => { });
//   // firebase.storage().ref('/path/to/ref').getDownloadURL().then(() => { });
//   //
//   // // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥
//
//   try {
//     let app = firebase.app();
//     let features = ['auth', 'database', 'messaging', 'storage'].filter(feature => typeof app[feature] === 'function');
//     document.getElementById('load').innerHTML = `Firebase SDK loaded with ${features.join(', ')}`;
//   } catch (e) {
//     console.error(e);
//     document.getElementById('load').innerHTML = 'Error loading the Firebase SDK, check the console.';
//   }
// });
