alert("Help me");
backgroundShift = () => {
    var backgrounds = [
        "midnightMeeting.png"
        , "guyOnGargoyle.jpg"
        , "futureCity.jpeg"
        , "foggyDockside.jpg"
        , "birdsEyeStreet.jpg"
    ];

    // var fs = require('fs');
    // var backgrounds = fs.readdirSync('images/')

    var picture = parseInt(Math.random() * backgrounds.length);
    console.log(picture + " " + backgrounds[picture]);

    var image = "url('/WorldOfFutureDarkness/images/" + backgrounds[picture] + "')";

    console.log(image);

    document.body.style.backgroundImage = image;
}

