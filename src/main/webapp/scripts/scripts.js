$(document).ready( () => {

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

    var element = document.getElementById("content");
    element.style.position = "absolute";

    var indent = (window.innerWidth / 2) - (element.offsetWidth / 2);
    element.style.left = indent + 'px';

    var vertical = (window.innerHeight / 2) - (element.offsetHeight / 2);
    element.style.top = vertical + 'px';


    $("#subCritterSubmit").on("click", () => {

        let critter         = $("#allowed :selected").prop("id");
        let subCritter      = $("#subCritterName").val();
        let category        = $("#category").val();
        let firstAdvantage  = $("#firstAdvantage").val();
        let secondAdvantage = $("#secondAdvantage").val();
        let flaw            = $("#flaw").val();

        subCritter = {"critter": critter
                 , "subCritter": subCritter
                   , "category": category
             , "firstAdvantage": firstAdvantage
            , "secondAdvantage": secondAdvantage
                       , "flaw": flaw
        }
        console.log(subCritter);
    });

})
