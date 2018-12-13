$(document).ready( () => {
    var CORE_LOCATION = "http://localhost:8080/WorldOfFutureDarkness/";

    backgroundFlip();


    centerTheThing();

    /*********************************************************************
     **                       Add New Subcritter                        **
     ** This function is called from admin/subCritter.jsp and sends a   **
     ** new subcritter to the subCritterCrud servelet to be added to    **
     ** to the data base.                                               **
     **                                                                 **
     ** When i have more time, and the rest of the application is done, **
     ** I would like to refactor this to user observables.              **
     *********************************************************************/
    $("#subCritterSubmit").on("click", () => {

        let critter         = $("#allowed :selected").prop("id");
        let subCritterName      = $("#subCritterName").val();
        let category        = $("#category").val();
        let firstAdvantage  = $("#firstAdvantage").val();
        let secondAdvantage = $("#secondAdvantage").val();
        let flaw            = $("#flaw").val();

        subCritter = {"critter": critter
                 , "subCritterName": subCritterName
                   , "category": category
             , "firstAdvantage": firstAdvantage
            , "secondAdvantage": secondAdvantage
                       , "flaw": flaw
        }

        //Make it standard postData for now.
        postData = `critter=${critter}`
            + `&subCritterName=${subCritterName}`
            + `&category=${category}`
            + `&firstAdvantage=${firstAdvantage}`
            + `&secondAdvantage=${secondAdvantage}`
            + `&flaw=${flaw}`;

        console.log(subCritter);

        $.ajax({
            url:CORE_LOCATION + "subCritterCRUD"
            , method: "POST"
            , data: postData
            , dataType: "TEXT"
            , success: function(responseText) {
                // let data = JSON.parse(responseText);
                console.log(responseText);
            }
            , error:function(xhr, status, error) {
                console.log("ERROR:");
                console.log(xhr.responseText);
                console.log(postData);
                console.log(status);
                console.log(error);

                //TODO: put some code here to put the failure on the webpage
            }
        })
    });

})


/*********************************************************************
 **                         Background flip                         **
 *********************************************************************/
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
centerTheThing = () => {
    var element = document.getElementById("content");
    element.style.position = "absolute";

    var indent = (window.innerWidth / 2) - (element.offsetWidth / 2);
    element.style.left = indent + 'px';

    var vertical = (window.innerHeight / 2) - (element.offsetHeight / 2);
    element.style.top = vertical + 'px';
}