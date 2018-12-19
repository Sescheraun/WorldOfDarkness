var localHost = "http://localhost:8080/WorldOfFutureDarkness/";
var aws = "http://18.224.147.146:8080/WorldOfFutureDarkness/";

var subCritterIndex = 0;
var subCritters = {};

var CORE_LOCATION = localHost;

$(document).ready( () => {

    backgroundFlip();

    centerTheThing();
    var title = document.getElementsByTagName("title")[0];

    title = title.innerHTML
    


    if (title == "Manage Sub Types") {
        console.log("Going to get all the subCritters")
        readAllSubCritters();
    }

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

        console.log("Submitting new subcritter");

        let critter         = $("#allowed :selected").prop("id");
        let subCritterName  = $("#subCritterNameNew").val();
        let category        = $("#categoryNew").val();
        let firstAdvantage  = $("#firstAdvantageNew").val();
        let secondAdvantage = $("#secondAdvantageNew").val();
        let flaw            = $("#flawNew").val();

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
            url: CORE_LOCATION + "subCritterCRUD"
            , method: "POST"
            , data: postData
            , dataType: "TEXT"
            , success: function(responseText) {
                // let data = JSON.parse(responseText);
                console.log(responseText);

                $("#subCritterNameNew").val("");
                $("#categoryNew").val("");
                $("#firstAdvantageNew").val("");
                $("#secondAdvantageNew").val("");
                $("#flawNew").val("");
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
    $("#subCritterUpdate").on("click", () => {

        let critter         = $("#allowed :selected").prop("id");
        let subCritterID    = $("#subCritterUpdateID").innerHTML;
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
     **                        Delete Subcritter                        **
     ** This function is called from admin/subCritter.jsp and sends a   **
     ** subcritterID to the subCritterCrud servelet to be removed from  **
     ** the data base. (Marked as deleted)                              **
     **                                                                 **
     ** When i have more time, and the rest of the application is done, **
     ** I would like to refactor this to user observables.              **
     **                                                                 **
     **           THIS METHOD IS NOT READY FOR IMPLEMENTATION           **
     *********************************************************************/
    $("#subCritterDelete").on("click", () => {

        let target = subCritters[subCritterIndex].subCritterId;

        //Make it standard postData for now.
        let postData = "method=delete&subCritterID=" + target;

        console.log(postData);

        $.ajax({
            url:CORE_LOCATION + "subCritterCRUD"
            , method: "POST"
            , data: postData
            , dataType: "TEXT"
            , success: function(responseText) {
                // let data = JSON.parse(responseText);
                console.log(responseText);
                readAllSubCritters();
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
 **                        Read Subcritters                         **
 ** This function is called from admin/subCritter.jsp and gets all  **
 ** the subcritters from the subCritterCrud servelet to be added to **
 ** displayed on the page for browsing by critter.  It require a    **
 ** critter ID to be used.                                          **
 **                                                                 **
 ** When i have more time, and the rest of the application is done, **
 ** I would like to refactor this to user observables.              **
 **                                                                 **
 *********************************************************************/
readAllSubCritters = () => {

    //let critter = $("#allowed :selected").prop("id");

    console.log("Getting all SubCritters");
    //Should not need
    //let postData = `critter=${critter}`;

    $.ajax({
        url:CORE_LOCATION + "subCritterCRUD"
        , method: "GET"
        //, data: postData
        , dataType: "text"
        , success: function(responseText) {
            // let data = JSON.parse(responseText);
            console.log("Success");
            console.log(responseText);
            subCritters = JSON.parse(responseText);
            console.log(subCritters[0].critter);
            loadSubCritters();

        }
        , error:function(xhr, status, error) {
            console.log("ERROR:");
            console.log(xhr.responseText);
            //console.log(postData);
            console.log(status);
            console.log(error);

        }
    })

    /*********************************************************************
     **                        Shift SubCritters                        **
     *********************************************************************/
    $(".PostLeft").on("click", function() {
        shiftSubCritters(-1);
    })


    $(".PostRight").on("click", function() {
        shiftSubCritters(1);
    })

};
/********************************************************************************
 **                         Changes the index of the journal                    **
 **                               based on user input                           **
 *********************************************************************************/


shiftSubCritters = (direction) => {
    subCritterIndex += direction;
    if (subCritterIndex >= subCritters.length) subCritterIndex = 0;
    if (subCritterIndex < 0) subCritterIndex = subCritters.length - 1;
    loadSubCritters();
}

/****************************************************************************
 **  Load the elements of the subCritter into the page as the user browses **
 **  them                                                                  **
 ****************************************************************************/
loadSubCritters = () => {
    //Delima, how do I replace the content when I don't know what it will be?
    //There is probably a better way to do this.

    console.log("Loading the Subcritters");


    $(".idDisplay").empty(subCritters[subCritterIndex].subCritterId);
    $(".idDisplay").append(subCritters[subCritterIndex].subCritterId);

    $("#subCritterNameUpdate").val(subCritters[subCritterIndex].subCritterLabel);
    $("#categoryUpdate").val(subCritters[subCritterIndex].critterSubName);

    $(".subCritterNameDisplay").empty(subCritters[subCritterIndex].subCritterLabel);
    $(".subCritterNameDisplay").append(subCritters[subCritterIndex].subCritterLabel);

    $(".categoryDisplay").empty(subCritters[subCritterIndex].secondAdvantage);
    $(".categoryDisplay").append(subCritters[subCritterIndex].secondAdvantage);

    $(".firstAdvantageDisplay").empty(subCritters[subCritterIndex].firstAdvantage);
    $(".firstAdvantageDisplay").append(subCritters[subCritterIndex].firstAdvantage);

    $(".secondAdvantageDisplay").empty(subCritters[subCritterIndex].secondAdvantage);
    $(".secondAdvantageDisplay").append(subCritters[subCritterIndex].secondAdvantage);

    $(".flawDisplay").empty(subCritters[subCritterIndex].flaw);
    $(".flawDisplay").append(subCritters[subCritterIndex].flaw);
}


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