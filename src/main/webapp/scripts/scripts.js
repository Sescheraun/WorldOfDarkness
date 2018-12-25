var width = 540;
var container;

$(document).ready( () => {

    container = document.body.style

    backgroundFlip();

    centerTheThing();

    copyrightFix();


})

$(window).resize( () => {

    backgroundFlip();
    centerTheThing();
    copyrightFix();
})

/*********************************************************************
 **                           Copyright Fix                         **
 *********************************************************************/
/**
 * Corrects the different sizes for the copyright buttons
 */
copyrightFix = () => {
    // The following block of code
    let one = document.getElementById("cpLink"),
        two = document.getElementById("WoDlink");

    if (one.offsetHeight > two.offsetHeight)
    {
        two.style.height = one.offsetHeight+"px";
    }else{
        one.style.height = two.offsetHeight+"px";
    }
}

/*********************************************************************
 **                         Background flip                         **
 *********************************************************************/
/**
 * Displayes a random background image.
 */
//I need to put code in here to not du this if on mobile.
backgroundFlip = () => {
    if( $(this).width() > width ) {

        var backgrounds = [
            "midnightMeeting.png"
            , "guyOnGargoyle.jpg"
            , "futureCity.jpeg"
            , "foggyDockside.jpg"
            , "birdsEyeStreet.jpg"
        ];

        var picture = parseInt(Math.random() * backgrounds.length);
        console.log(picture + " " + backgrounds[picture]);

        var image = "url('/WorldOfFutureDarkness/images/" + backgrounds[picture] + "')";

        console.log(image);

        container.backgroundImage = image;
        container.backgroundRepeat = "noRepeat";

    } else {
        container.backgroundImage = "";
        container.backgroundColor = "black";
    }

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