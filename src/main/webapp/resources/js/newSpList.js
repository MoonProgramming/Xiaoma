//create firebase reference
var dbRef = firebase.database();
var serviceProviderRef = dbRef.ref('spPublic');
var storage = firebase.storage();


//load older SP as well as any newly added one...

var spList = [];
var jsonArray = [];



serviceProviderRef.once('value').then(snapshot => {
    var spList = [];

    snapshot.forEach(childSnap => {
        //        const key = childSnap.key

        if (childSnap.val().searchable == 'true' && childSnap.val().veryfied) {
            console.log("added", childSnap.key, childSnap.val());
            spList.push(childSnap);
        }

    });

    return Promise.all(spList);
}).then(function (spList) {

    jsonArray = JSON.parse(JSON.stringify(spList));

    return jsonArray;
}).then(function () {

    //    $('#price_filter').val('0-500');
    //    $("#price_slider").slider({
    //        range: true,
    //        min: 0,
    //        max: 500,
    //        values: [0, 500],
    //        step: 5,
    //        slide: function (event, ui) {
    //            $("#price_range_label").html('$' + ui.values[0] + ' - $' + ui.values[1]);
    //            $('#price_filter').val(ui.values[0] + '-' + ui.values[1]).trigger('change');
    //        }
    //    });
    //
    //    $('#status :checkbox').prop('checked', false);




    FilterJS(jsonArray, "#service_list", {
        template: '#template',
        criterias: [
            {
                field: 'experience',
                ele: '#exp_filter',
                all: 'all'

                },
            {
                field: 'state',
                ele: '#location_filter',
                all: 'all'
                },
            {
                field: 'language_mandarin',
                ele: '#filter_chinese'
            },
            {
                field: 'language_cantonese',
                ele: '#filter_cantonese'
            },
            {
                field: 'language_hakka',
                ele: '#filter_hakka'
            },
            {
                field: 'language_hokkien',
                ele: '#filter_hokkien'
            },
            {
                field: 'language_english',
                ele: '#filter_english'
            },
            {
                field: 'language_malay',
                ele: '#filter_malay'
            },
        ],
        search: {
            ele: '#search_box'
        }
    });

    //when show profile button clicked
    $('.showProfile').on('click', function (e) {

        var spUid = $(this).attr("data"); // GET THE DATA IN ATTR

        firebase.auth().onAuthStateChanged(function (user) {
            if (user) {
                var favoriteRef = firebase.database().ref('/users/' + user.uid + '/favorite');

                event.preventDefault();
                $('#sp-profileModal').modal('show');


                // create carousel item
                var galleryRef = firebase.database().ref('/spPublic/' + spUid + '/gallery').orderByKey();
                galleryRef.once('value', function (snapshot) {


                    var i = 0;
                    $('.carousel-inner').html('');
                    snapshot.forEach(function (item) {
                        i++;
                        $('<div class="item" data-slide-number="' + i + '"><img class="img-rounded galleryPic' + i + '" src="">   </div>').appendTo('.carousel-inner');

                    })
                    console.log("Query successful.");
                    $('.item').first().addClass('active');
                    $('#myCarousel').carousel();

                });


                // read database public
                firebase.database().ref('/spPublic/' + spUid).on('value', function (snapshot) {
                    console.log(snapshot.val());


                    // assign data to variables
                    var nickname = snapshot.val().nickname;
                    var birthdate = snapshot.val().birthdate;
                    var experience = snapshot.val().experience;
                    var state = snapshot.val().state;
                    var countryISO = snapshot.val().countryISO;
                    var work24hours = snapshot.val().work24hours;
                    var selfIntro = snapshot.val().selfIntro;
                    var language_mandarin = snapshot.val().language_mandarin;
                    var language_cantonese = snapshot.val().language_cantonese;
                    var language_hakka = snapshot.val().language_hakka;
                    var language_hokkien = snapshot.val().language_hokkien;
                    var language_english = snapshot.val().language_english;
                    var language_malay = snapshot.val().language_malay;
                    var language_others = snapshot.val().language_others;
                    var searchable = snapshot.val().searchable;
                    var galleryPic1 = snapshot.val().gallery.galleryPic1;
                    var galleryPic2 = snapshot.val().gallery.galleryPic2;
                    var galleryPic3 = snapshot.val().gallery.galleryPic3;
                    var galleryPic4 = snapshot.val().gallery.galleryPic4;
                    var galleryPic5 = snapshot.val().gallery.galleryPic5;
                    var galleryPic6 = snapshot.val().gallery.galleryPic6;

                    //      $("#portraitURL").attr('src', portraitURL);
                    //      $("#profilePicURL").attr('src', portraitURL);
                    $("#nickname").html(nickname);
                    $("#birthdate").html(birthdate);
                    $("#experience").html(experience);
                    $("#state").html(state);
                    $("#countryISO").html(countryISO);
                    $("#work24hours").html(work24hours);
                    $("#selfIntro").html(selfIntro);
                    $("#language_mandarin").html(language_mandarin);
                    $("#language_cantonese").html(language_cantonese);
                    $("#language_hakka").html(language_hakka);
                    $("#language_hokkien").html(language_hokkien);
                    $("#language_english").html(language_english);
                    $("#language_malay").html(language_malay);
                    $("#language_others").html(language_others);

                    $(".galleryPic1").attr('src', galleryPic1);
                    $(".galleryPic2").attr('src', galleryPic2);
                    $(".galleryPic3").attr('src', galleryPic3);
                    $(".galleryPic4").attr('src', galleryPic4);
                    $(".galleryPic5").attr('src', galleryPic5);
                    $(".galleryPic6").attr('src', galleryPic6);


                    // if user is SP, hide favoriteButton
                    // read user database
                    firebase.database().ref('/users/' + user.uid).once('value', function (snapshot) {
                        console.log(snapshot.val());

                        if (snapshot.val() == null) {
                            $(".favoriteButton").hide();
                        } else {

                            //read User favorite
                            favoriteRef.child(spUid).once('value', function (snapshot) {
                                console.log(snapshot.val());

                                var favorite = snapshot.val();
                                console.log(snapshot.key);

                                if (snapshot.val() == null) {
                                    $(".favoriteButton").attr('value', '列入我的人選');
                                    $('.favoriteButton').html('<span class="fa fa-heart"></span> 列入我的人選');
                                } else {
                                    $('.favoriteButton').attr('value', '取消人選');
                                    $('.favoriteButton').html('<span class="fa fa-ban"></span> 取消人選');
                                }
                            });


                            // when favoriteButton is pressed
                            $('.favoriteButton').on('click', function (e) {

                                if ($('.favoriteButton').val() == '取消人選') {

                                    $('.favoriteButton').attr('value', '列入我的人選');
                                    $('.favoriteButton').html('<span class="fa fa-heart"></span> 列入我的人選');

                                    favoriteRef.child(spUid).remove();
                                    console.log('SP removed from favorite');
                                } else {

                                    $('.favoriteButton').attr('value', '取消人選');
                                    $('.favoriteButton').html('<span class="fa fa-ban"></span> 取消人選');

                                    favoriteRef.child(spUid).set(true);
                                    console.log('SP added to favorite');
                                }
                            })


                            // unbind buttons after modal closed
                            $('#sp-profileModal').on('hidden.bs.modal', function () {
                                $('.favoriteButton').off('click');
                            });
                        }
                    });


                });
            } else {
                // no user sign-in
                // direct user to sign-in or register
                // pop-up login modal
                e.preventDefault

                $('#messageModalLabel').html('<span class="text-center text-info">請先登入或註冊帳戶</span>');
                $('#messageModal').modal('show');

            }
        });




    });
})
