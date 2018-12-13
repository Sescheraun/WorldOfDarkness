$(document).ready( () => {
    var CORE_LOCATION = "http://localhost:8080/WorldOfFutureDarkness/";

    backgroundFlip();


    centerTheThing();

    /*********************************************************************
     **                        Create Subcritter                        **
     ** This function is called from admin/subCritter.jsp and sends a   **
     ** new subcritter to the subCritterCrud servelet to be added to    **
     ** to the data base.                                               **
     **                                                                 **
     ** When i have more time, and the rest of the application is done, **
     ** I would like to refactor this to user observables.              **
     *********************************************************************/
    $("#subCritterSubmit").on("click", () => {

        let critter         = $("#allowed :selected").prop("id");
        let subCritterName  = $("#subCritterName").val();
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

            }
        })
    });

    /*********************************************************************
     **                        Update Subcritter                        **
     ** This function is called from admin/subCritter.jsp and sends a   **
     ** altered subcritter to the subCritterCrud servelet to be revised **
     ** in the data base.                                               **
     **                                                                 **
     ** When i have more time, and the rest of the application is done, **
     ** I would like to refactor this to user observables.              **
     **                                                                 **
     **           THIS METHOD IS NOT READY FOR IMPLEMENTATION           **
     *********************************************************************/
    $("#subCritterSubmit").on("click", () => {

        let critter         = $("#allowed :selected").prop("id");
        let subCritterID    = $("#subCritterID").val();
        let subCritterName  = $("#subCritterName").val();
        let category        = $("#category").val();
        let firstAdvantage  = $("#firstAdvantage").val();
        let secondAdvantage = $("#secondAdvantage").val();
        let flaw            = $("#flaw").val();

        //Make it standard postData for now.
        postData = `critter=${critter}`
            + `&subCritterName=${subCritterName}`
            + `&category=${category}`
            + `&firstAdvantage=${firstAdvantage}`
            + `&secondAdvantage=${secondAdvantage}`
            + `&flaw=${flaw}`;

        $.ajax({
            url:CORE_LOCATION + "subCritterCRUD"
            , method: "PUT"
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

            }
        })
    });

    /*********************************************************************
     **                        Read Subcritters                         **
     ** This function is called from admin/subCritter.jsp and gets all  **
     ** the subcritters from the subCritterCrud servelet to be added to **
     ** displayed on the page for browsing by critter.  It require a    **
     ** critter ID to be used.                                          **
     **                                                                 **
     ** When i have more time, and the rest of the application is done, **
     ** I would like to refactor this to user observables.              **
     **                                                                 **
     **           THIS METHOD IS NOT READY FOR IMPLEMENTATION           **
     *********************************************************************/    $("#subCritterSubmit").on("click", () => {

        let critter         = $("#allowed :selected").prop("id");

        //Make it standard postData for now.
        postData = `critter=${critter}`;

        console.log(subCritter);

        $.ajax({
            url:CORE_LOCATION + "subCritterCRUD"
            , method: "GET"
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

            }
        })
    });

    /*********************************************************************
     **                        Delete Subcritter                        **
     ** This function is called from admin/subCritter.jsp and sends a   **
     ** subcritterID to the subCritterCrud servelet to be removed from  **
     ** the data base. (Marked as deleted)                              **
     **                                                                 **
     ** When i have more time, and the rest of the application is done, **
     ** I would like to refactor this to user observables.              **
     **                                                                 **
     **           THIS METHOD IS NOT READY FOR IMPLEMENTATION           **
     *********************************************************************/    $("#subCritterSubmit").on("click", () => {

        let subCritterID    = $("#subCritterID").val();

        //Make it standard postData for now.
        postData = `subCritterID=${subCritterID}`;

        console.log(subCritter);

        $.ajax({
            url:CORE_LOCATION + "subCritterCRUD"
            , method: "DELETE"
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