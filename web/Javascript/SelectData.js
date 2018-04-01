/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



var t;
var boo;
var idname;
var inputdate;
var lastestdata;
function setheart() {
    t = "Heartrate_Detail";
    inputdate = "#heartdate";
    lastestdata = "heartvalue";
}
function setsleep() {
    t = "Sleep_Detail";
    inputdate = "#date";
    lastestdata = "sleepvalue";
}
function setSummary() {
    t = "Summary";
    inputdate = "#date";
    lastestdata = "sleepvalue";
}
function setAC() {
    t = "Activity_Detail";
    inputdate = "#ACdate";
    lastestdata = "sleepvalue";
}
function setgame() {
    t = "PVT_History";
    inputdate = "#gamedate";
}

function SelectDataheart() {

    var user = getuser;
    var date = $(inputdate).val();
    resultdate = date;

    var table = t;
    var data1 = {
        user: getuser,
        date: date,
        table: table
    };
    console.log(data1);


    $.ajax({
        type: "Get",
        url: "SelectDetailData.jsp",
        data: data1,
        cache: false,
        success: function (data) {
            console.log(data.size);
            Alldata = jQuery.trim(data).split("?");
            timedata = jQuery.trim(Alldata[0]).split("\n");
            valuedata = jQuery.trim(Alldata[1]).split("\n");
            if (timedata.length > 1) {
                for (var i = 0; i < timedata.length; i++) {
                    timedata[i] = jQuery.trim(timedata[i]);
                    valuedata[i] = jQuery.trim(valuedata[i]);
                }
                setTimeout(drawheart,0);

            }
        },
        error: function (xhr, ajaxOptions, thrownError) {
            console.log("error");
            alert("error");
        }
    });

}
function SelectDataAC() {

    var user = getuser;
    var date = $(inputdate).val();
    resultdate = date;

    var table = t;
    var data1 = {
        user: getuser,
        date: date,
        table: table
    };
    console.log(data1);


    $.ajax({
        type: "Get",
        url: "SelectDetailData.jsp",
        data: data1,
        cache: false,
        success: function (data) {
            Alldata = jQuery.trim(data).split("?");
            timedata = jQuery.trim(Alldata[0]).split("\n");
            valuedata = jQuery.trim(Alldata[1]).split("\n");
            efficiency = jQuery.trim(Alldata[2]).split("\n");
            if (timedata.length > 1) {
                for (var i = 0; i < timedata.length; i++) {
                    timedata[i] = jQuery.trim(timedata[i]);
                    valuedata[i] = jQuery.trim(valuedata[i]);
                    efficiency[i] = jQuery.trim(efficiency[i]);
                    console.log(timedata[i]);
                }
                drawAC();


            }
        },
        error: function (xhr, ajaxOptions, thrownError) {
            console.log("error");
            alert("error");
        }
    });

}

function GetStatusList() {

    var user = getuser;
    var date = $(inputdate).val();
    var data1 = {
        user: user,
        date: date,
        value: "1",
    };
    console.log(data1);
    $.ajax({
        type: "Get",
        url: "StatusList.jsp",
        data: data1,
        cache: false,
        success: function (response) {
             document.getElementById("statuslist").innerHTML=response;
             GetWork();
        },
        error: function (xhr, ajaxOptions, thrownError) {
            console.log("error");
            alert("error");
        }
    });
}
function GetWork() {

    var user = getuser;
    var date = $(inputdate).val();
    var data1 = {
        user: user,
        date: date,
        value: "1",
    };
    console.log(data1);
    $.ajax({
        type: "Get",
        url: "Work.jsp",
        data: data1,
        cache: false,
        success: function (response) {
            console.log(response);
             document.getElementById("worktime").innerHTML=response;
        },
        error: function (xhr, ajaxOptions, thrownError) {
            console.log("error");
            alert("error");
        }
    });
}
function SelectDataGame() {

    var user = getuser;
    var date = $(inputdate).val();

    var table = t;
    var data1 = {
        user: getuser,
        date: date,
        table: table
    };
    console.log(data1);


    $.ajax({
        type: "Get",
        url: "SelectDetailData.jsp",
        data: data1,
        cache: false,
        success: function (data) {
            console.log("success game");
            console.log(data);
            Alldata = jQuery.trim(data).split("?");
            console.log(Alldata);
            timedata = jQuery.trim(Alldata[0]).split("\n");
            valuedata = jQuery.trim(Alldata[1]).split("\n");
            contimedata = jQuery.trim(Alldata[2]).split("\n");
            convaluedata = jQuery.trim(Alldata[3]).split("\n");
            if (timedata.length > 1) {
                for (var i = 0; i < timedata.length; i++) {
                    timedata[i] = jQuery.trim(timedata[i]);
                    valuedata[i] = jQuery.trim(valuedata[i]);
                    console.log(timedata[i]);
                     
                    
                }
                setTimeout(drawgame,0);

            }
            if (contimedata.length >= 1) {
                for (var i = 0; i < contimedata.length; i++) {
                    contimedata[i] = jQuery.trim(contimedata[i]);
                    convaluedata[i] = jQuery.trim(convaluedata[i]);
                    console.log(contimedata[i]);
                    

                }
                setTimeout(drawcon,0);

            }
        },
        error: function (xhr, ajaxOptions, thrownError) {
            console.log("error");
            alert("error");
        }
    });
}
function SelectDataMoreAC() {

    var user = getuser;
    var date = $(inputdate).val();
    resultdate = date;
    var value = v;
    var table = t;
    var data1 = {
        user: getuser,
        date: date,
        table: table,
        value: value
    };
    console.log(data1);


    $.ajax({
        type: "Get",
        url: "GetChartDetail.jsp",
        data: data1,
        cache: false,
        success: function (data) {
            Alldata = jQuery.trim(data).split("?");
            timedata = jQuery.trim(Alldata[0]).split("\n");
            valuedata = jQuery.trim(Alldata[1]).split("\n");
            if (timedata.length > 1) {
                for (var i = 0; i < timedata.length; i++) {
                    timedata[i] = jQuery.trim(timedata[i]);
                    valuedata[i] = jQuery.trim(valuedata[i]);

                }
                drawAC();


            }
        },
        error: function (xhr, ajaxOptions, thrownError) {
            console.log("error");
            alert("error");
        }
    });

}
function UpdateDB() {

    var user = getuser;
    var date = $(inputdate).val();
    resultdate = date;

    var table = t;
    var data1 = {
        user: getuser,
        date: date,
        table: table
    };
    console.log(data1);


    $.ajax({
        type: "Get",
        url: "Update.jsp",
        data: data1,
        cache: false,
        success: function (data) {
            console.log("sucess");
        },
        error: function (xhr, ajaxOptions, thrownError) {
            console.log("error");
            alert("error");
        }
    });

}
function SelectDatasleep() {

    var user = getuser;
    var date = $(inputdate).val();
    resultdate = date;

    var table = t;
    var data1 = {
        user: getuser,
        date: date,
        table: table
    };
    var data2 = {
        user: getuser,
        date: date,
        table: "Summary"
    };
    console.log(data2);
    $.ajax({
        type: "Get",
        url: "SelectDetailData.jsp",
        data: data2,
        cache: false,
        success: function (data) {
            console.log(data.size);
            Alldata = jQuery.trim(data).split("?");
            timedata = jQuery.trim(Alldata[0]).split("\n");
            valuedata = jQuery.trim(Alldata[1]).split("\n");
            efficiency = jQuery.trim(Alldata[2]).split("\n");
            if (timedata.length > 1) {
                for (var i = 0; i < timedata.length; i++) {
                    timedata[i] = jQuery.trim(timedata[i]);
                    valuedata[i] = jQuery.trim(valuedata[i]);
                    efficiency[i] = jQuery.trim(efficiency[i]);
                    console.log(timedata[i]);
                }



            }
            console.log("hi");
            drawtime();
            drawminutes();
        },
        error: function (xhr, ajaxOptions, thrownError) {
            console.log("error");
            alert("error");
        }
    });

    $.ajax({
        type: "Get",
        url: "SelectDetailData.jsp",
        data: data1,
        cache: false,
        success: function (data) {
            console.log(data.size);
            Alldata = jQuery.trim(data).split("?");
            timedata = jQuery.trim(Alldata[0]).split("\n");
            valuedata = jQuery.trim(Alldata[1]).split("\n");
            if (timedata.length > 1) {
                for (var i = 0; i < timedata.length; i++) {
                    timedata[i] = jQuery.trim(timedata[i]);
                    valuedata[i] = jQuery.trim(valuedata[i]);
                }

                drawSleep();

            }
        },
        error: function (xhr, ajaxOptions, thrownError) {
            console.log("error");
            alert("error");
        }
    });


}
var v;
function setweek() {
    v = 7;
}
function setmonth() {
    v = 30;
}
function SelectMoreDataheart() {

    var user = getuser;
    var date = $(inputdate).val();

    var value = v;
    var table = t;
    var data1 = {
        user: getuser,
        date: date,
        table: table,
        value: value
    };
    console.log(data1);


    $.ajax({
        type: "Get",
        url: "GetChartDetail.jsp",
        data: data1,
        cache: false,
        success: function (data) {
            console.log(data.size);
            Alldata = jQuery.trim(data).split("?");
            resultdate = jQuery.trim(Alldata[0]).split("\n");
            timedata = jQuery.trim(Alldata[1]).split("\n");
            valuedata = jQuery.trim(Alldata[2]).split("\n");
            if (timedata.length > 1) {
                for (var i = 0; i < timedata.length; i++) {
                    resultdate[i] = jQuery.trim(resultdate[i]);
                    timedata[i] = jQuery.trim(timedata[i]);
                    valuedata[i] = jQuery.trim(valuedata[i]);
                }

            }
            console.log(resultdate.length);
            console.log(valuedata.length);
            draw2heart();
        },
        error: function (xhr, ajaxOptions, thrownError) {
            console.log("error");
            alert("error");
        }
    });
}
function SelectMoreGame() {

    var user = getuser;
    var date = $(inputdate).val();

    var value = v;
    var table = t;
    var data1 = {
        user: getuser,
        date: date,
        table: table,
        value: value
    };
    console.log(data1);


    $.ajax({
        type: "Get",
        url: "GetChartDetail.jsp",
        data: data1,
        cache: false,
        success: function (data) {
            Alldata = jQuery.trim(data).split("?");
            timedata = jQuery.trim(Alldata[0]).split("\n");
            valuedata = jQuery.trim(Alldata[1]).split("\n");
            contimedata = jQuery.trim(Alldata[2]).split("\n");
            convaluedata = jQuery.trim(Alldata[3]).split("\n");
            if (timedata.length > 1) {
                for (var i = 0; i < timedata.length; i++) {
                    timedata[i] = jQuery.trim(timedata[i]);
                    valuedata[i] = jQuery.trim(valuedata[i]);
                    contimedata[i] = jQuery.trim(contimedata[i]);
                    convaluedata[i] = jQuery.trim(convaluedata[i]);
                }
                drawgame();
                drawcon();
GetMoreStatusList();

            }
        },
        error: function (xhr, ajaxOptions, thrownError) {
            console.log("error");
            alert("error");
        }
    });

}
function GetMoreWork() {

    var user = getuser;
    var date = $(inputdate).val();
    var value = v;
    var data1 = {
        user: user,
        date: date,
        value:value
    };
    console.log(data1);
    $.ajax({
        type: "Get",
        url: "Work.jsp",
        data: data1,
        cache: false,
        success: function (response) {
            console.log(response);
             document.getElementById("worktime").innerHTML=response;
        },
        error: function (xhr, ajaxOptions, thrownError) {
            console.log("error");
            alert("error");
        }
    });
}
function GetMoreStatusList() {

    var user = getuser;
    var date = $(inputdate).val();
    var value = v;
    var data1 = {
        user: user,
        date: date,
        value: value
    };
    console.log(data1);
    $.ajax({
        type: "Get",
        url: "StatusList.jsp",
        data: data1,
        cache: false,
        success: function (response) {
             document.getElementById("statuslist").innerHTML=response;
             GetMoreWork();
        },
        error: function (xhr, ajaxOptions, thrownError) {
            console.log("error");
            alert("error");
        }
    });
}
function SelectMoreDatasleep2() {
    var user = getuser;
    var date = $(inputdate).val();

    var value = v;
    var table = t;

    var data2 = {
        user: getuser,
        date: date,
        table: "Summary",
        value: value
    };
    console.log(data2);

    $.ajax({
        type: "Get",
        url: "GetChartDetail.jsp",
        data: data2,
        cache: false,
        success: function (data) {
            console.log(data.size);
            Alldata = jQuery.trim(data).split("?");
            resultdate = jQuery.trim(Alldata[0]).split("\n");
            timedata = jQuery.trim(Alldata[1]).split("\n");
            valuedata = jQuery.trim(Alldata[2]).split("\n");
            if (timedata.length > 1) {
                for (var i = 0; i < timedata.length; i++) {
                    timedata[i] = jQuery.trim(timedata[i]);
                    valuedata[i] = jQuery.trim(valuedata[i]);
                    resultdate[i] = jQuery.trim(resultdate[i]);
                }



            }
            console.log("hi2");
            console.log(Alldata);
            draw2times();
            draw2minutes();
        },
        error: function (xhr, ajaxOptions, thrownError) {
            console.log("error");
            alert("error");
        }
    });
}
function SelectMoreDatasleep() {

    var user = getuser;
    var date = $(inputdate).val();

    var value = v;
    var table = t;
    var data1 = {
        user: getuser,
        date: date,
        table: table,
        value: value
    };
    console.log(data1);

    $.ajax({
        type: "Get",
        url: "GetChartDetail.jsp",
        data: data1,
        cache: false,
        success: function (data) {
            console.log(data.size);
            Alldata = jQuery.trim(data).split("?");
            timedata = jQuery.trim(Alldata[0]).split("\n");
            valuedata = jQuery.trim(Alldata[1]).split("\n");
            efficiency = jQuery.trim(Alldata[2]).split("\n");
            if (timedata.length > 1) {
                for (var i = 0; i < timedata.length; i++) {
                    timedata[i] = jQuery.trim(timedata[i]);
                    valuedata[i] = jQuery.trim(valuedata[i]);
                }

            }
            efficiency[0] = jQuery.trim(efficiency[0]);
            console.log(valuedata.length);
            draw2sleep();
        },
        error: function (xhr, ajaxOptions, thrownError) {
            console.log("error");
            alert("error");
        }
    });

}