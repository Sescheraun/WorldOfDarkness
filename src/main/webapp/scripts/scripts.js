
$(document).ready( () => {

    backgroundFlip();

    centerTheThing();

})

$(window).resize( () => {

    // backgroundFlip();

    centerTheThing();
})


/*********************************************************************
 **                         Background flip                         **
 *********************************************************************/
/**
 * Displayes a random background image.
 */
//I need to put code in here to not du this if on mobile.
backgroundFlip = () => {
    var backgrounds = [
        "midnightMeeting.png"
        , "guyOnGargoyle.jpg"
        , "futureCity.jpeg"
        , "foggyDockside.jpg"
        , "birdsEyeStreet.jpg"
    ];

    var picture = parseInt(Math.random() * backgrounds.length);
    console.log(picture + " " + backgrounds[picture]);

    container = document.body.style;

    var image = "url('/WorldOfFutureDarkness/images/" + backgrounds[picture] + "')";

    console.log(image);

    container.backgroundImage = image;
    container.backgroundRepeat = "noRepeat";
}

/*********************************************************************
 **                          Center Things                          **
 *********************************************************************/
/**
 * Centers the content element both vertically and horizontally
 */
centerTheThing = () => {
    var element = document.getElementById("content");
    element.style.position = "absolute";

    var indent = (window.innerWidth / 2) - (element.offsetWidth / 2);
    element.style.left = indent + 'px';

    var vertical = (window.innerHeight / 2) - (element.offsetHeight / 2);
    element.style.top = vertical + 'px';
}