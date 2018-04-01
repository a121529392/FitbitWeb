/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function load() {
    jQuery.post("GetUser.jsp", updateNumber);
    function updateNumber(data)
    {

        var numberData = jQuery.trim(data).split("\n");//用 \n 來做分資料分割
        $('select#user').append($('<option></option>').attr('value', 0).text('Choose A User'));
        $('select#user2').append($('<option></option>').attr('value', 0).text('Choose A User'));
        for (i = 0; i < numberData.length; i++)
        {
            numberData[i] = jQuery.trim(numberData[i]);
            $('select#user').append($('<option></option>').attr('value', numberData[i]).text(numberData[i]));
            $('select#user2').append($('<option></option>').attr('value', numberData[i]).text(numberData[i]));

        }

    }

}

function GetHeartrateSumJson() {
    document.getElementById("goal").innerHTML = "";
    var user = $("#user").val();
    var date = $("#date").val();
    var period = $("#period").val();
    var data1 = {
        user: user,
        date: date,
        period: period
    };
    console.log(data1);
    $.ajax({
        type: "Get",
        url: "GetHeartrate_Sum.jsp",
        data: data1,
        cache: false,
        success: function (response) {
            document.getElementById("goal").innerHTML = "Success";
            console.log("success");
            console.log(response);
            //$("#jsonret").val(response);
        },
        error: function (xhr, ajaxOptions, thrownError) {
            console.log("error");
            alert("error");
        }
    });
}
function GetHeartrateDetailJson() {
    document.getElementById("goal").innerHTML = "";
    var user = $("#user").val();
    var date = $("#date").val();
    var period = "1min";
    var starttime = "00:00";
    var endtime = "23:59";
    var data1 = {
        user: user,
        date: date,
        period: period,
        starttime: starttime,
        endtime: endtime
    };
    console.log(data1);
    $.ajax({
        type: "Get",
        url: "GetHeartrate_Detail.jsp",
        data: data1,
        cache: false,
        success: function (response) {
            document.getElementById("goal").innerHTML = "Success";
            console.log("success");
            console.log(response);
            //$("#jsonret").val(response);
        },
        error: function (xhr, ajaxOptions, thrownError) {
            console.log("error");
            alert("error");
        }
    });
    
}
function GetActDetailJson() {
    document.getElementById("goal").innerHTML = "";
    var user = $("#user").val();
    var date = $("#date").val();
    var id = $("#actid").val();
    var period = $("#period").val();
    var starttime = $("#starttime").val();
    var endtime = $("#edtime").val();
    var data1 = {
        user: user,
        date: date,
        period: period,
        starttime: starttime,
        endtime: endtime,
        actid: id
    };
    console.log(data1);
    $.ajax({
        type: "Get",
        url: "GetAct_Detail.jsp",
        data: data1,
        cache: false,
        success: function (response) {
            console.log("success");
            console.log(response);
            document.getElementById("goal").innerHTML = "Success";
            //$("#jsonret").val(response);
        },
        error: function (xhr, ajaxOptions, thrownError) {
            console.log("error");
            alert("error");
        }
    });
}
function GetActSumJson() {
    document.getElementById("goal").innerHTML = "";
    var user = $("#user").val();
    var date = $("#date").val();
    var data1 = {
        user: user,
        date: date
    };
    console.log(data1);
    $.ajax({
        type: "Get",
        url: "GetAct_Sum.jsp",
        data: data1,
        cache: false,
        success: function (response) {
            console.log("success");
            console.log(response);
            document.getElementById("goal").innerHTML = "Success";
            //$("#jsonret").val(response);
        },
        error: function (xhr, ajaxOptions, thrownError) {
            console.log("error");
            alert("error");
        }
    });
}
function GetSleepOneDayJson() {
    document.getElementById("goal").innerHTML = "";
    var user = $("#user").val();
    var date = $("#date").val();
    var data1 = {
        user: user,
        date: date
    };
    console.log(data1);
    $.ajax({
        type: "Get",
        url: "GetSleep_One.jsp",
        data: data1,
        cache: false,
        success: function (response) {
            console.log("success");
            console.log(response);
            document.getElementById("goal").innerHTML = "Success";
            //$("#jsonret").val(response);
        },
        error: function (xhr, ajaxOptions, thrownError) {
            console.log("error");
            alert("error");
        }
    });
}
function GetSleepMoreDaysJson() {
    document.getElementById("goal").innerHTML = "";
    var user = $("#user").val();
    var date = $("#date").val();
    var enddate = $("#enddate").val();
    var data1 = {
        user: user,
        date: date,
        enddate: enddate
    };
    console.log(data1);
    $.ajax({
        type: "Get",
        url: "GetSleep_More.jsp",
        data: data1,
        cache: false,
        success: function (response) {
            console.log("success");
            console.log(response);
            document.getElementById("goal").innerHTML = "Success";
            //$("#jsonret").val(response);
        },
        error: function (xhr, ajaxOptions, thrownError) {
            console.log("error");
            alert("error");
        }
    });
}

