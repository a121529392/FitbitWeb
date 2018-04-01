/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function myFunction() {
    document.getElementById("goal").innerHTML = "";
    document.getElementById('user').style.visibility = 'hidden';
    document.getElementById('sub').type = 'hidden';
    document.getElementById('usertext').style.display = "none";
    document.getElementById('date').type = 'hidden';
    document.getElementById('datetext').style.display = "none";
    document.getElementById('period').type = 'hidden';
    document.getElementById('periodtext').style.display = "none";
    document.getElementById('starttime').type = 'hidden';
    document.getElementById('stimetext').style.display = "none";
    document.getElementById('edtime').type = 'hidden';
    document.getElementById('edtimetext').style.display = "none";
    document.getElementById('enddate').type = 'hidden';
    document.getElementById('enddatetext').style.display = "none";
    document.getElementById('actid').style.visibility = 'hidden';
    document.getElementById('idtext').style.display = "none";
    document.getElementById("sumtype").value = "choose";
    document.getElementById("day").value = "choose1";
    var sum = document.getElementById('sumtype');
    var x = document.getElementById("choose").value;
    if (x == "HR" || x == "ACT") {
        sum.style.display = 'inline';
        document.getElementById('day').style.display = 'none';

    } else {
        sum.style.display = 'none';
        document.getElementById('day').style.display = 'inline';
    }
}
function showinput() {

    document.getElementById('user').style.visibility = 'visible';
    var x = document.getElementById("choose").value;
    if (x == "HR" || x == "ACT") {
        var y = document.getElementById("sumtype").value;
    }
    if (x == "SLEEP") {
        var y = document.getElementById("day").value;
    }
    document.getElementById('sub').type = 'button';
    document.getElementById('usertext').style.display = "inline";
    document.getElementById('date').type = 'text';
    document.getElementById('datetext').style.display = "inline";
    if (x == "HR" && y == "sum") {

        document.getElementById('period').type = 'text';
        document.getElementById('periodtext').style.display = "inline";

        document.getElementById('starttime').type = 'hidden';
        document.getElementById('stimetext').style.display = "none";
        document.getElementById('edtime').type = 'hidden';
        document.getElementById('edtimetext').style.display = "none";
        document.getElementById('enddate').type = 'hidden';
        document.getElementById('enddatetext').style.display = "none";
        document.getElementById('actid').style.visibility = 'hidden';
        document.getElementById('idtext').style.display = "none";
        document.getElementById('sub').onclick = GetHeartrateSumJson;
    }
    if (x == "HR" && y == "detail") {
        document.getElementById('period').type = 'text';
        document.getElementById('periodtext').style.display = "inline";
        document.getElementById('starttime').type = 'text';
        document.getElementById('stimetext').style.display = "inline";
        document.getElementById('edtime').type = 'text';
        document.getElementById('edtimetext').style.display = "inline";
        document.getElementById('enddate').type = 'hidden';
        document.getElementById('enddatetext').style.display = "none";
        document.getElementById('actid').style.visibility = 'hidden';
        document.getElementById('idtext').style.display = "none";
        document.getElementById('sub').onclick = GetHeartrateDetailJson;
    }
    if (x == "SLEEP" && y == "one") {
        document.getElementById('period').type = 'hidden';
        document.getElementById('periodtext').style.display = "none";
        document.getElementById('starttime').type = 'hidden';
        document.getElementById('stimetext').style.display = "none";
        document.getElementById('edtime').type = 'hidden';
        document.getElementById('edtimetext').style.display = "none";
        document.getElementById('enddate').type = 'hidden';
        document.getElementById('enddatetext').style.display = "none";
        document.getElementById('actid').style.visibility = 'hidden';
        document.getElementById('idtext').style.display = "none";
        document.getElementById('sub').onclick = GetSleepOneDayJson;
    }
    if (x == "SLEEP" && y == "more") {

        document.getElementById('period').type = 'hidden';
        document.getElementById('periodtext').style.display = "none";
        document.getElementById('starttime').type = 'hidden';
        document.getElementById('stimetext').style.display = "none";
        document.getElementById('edtime').type = 'hidden';
        document.getElementById('edtimetext').style.display = "none";
        document.getElementById('enddate').type = 'text';
        document.getElementById('enddatetext').style.display = "inline";
        document.getElementById('actid').style.visibility = 'hidden';
        document.getElementById('idtext').style.display = "none";
        document.getElementById('sub').onclick = GetSleepMoreDaysJson;
    }
    if (x == "ACT" && y == "detail") {
        document.getElementById('period').type = 'text';
        document.getElementById('periodtext').style.display = "inline";
        document.getElementById('starttime').type = 'text';
        document.getElementById('stimetext').style.display = "inline";
        document.getElementById('edtime').type = 'text';
        document.getElementById('edtimetext').style.display = "inline";
        document.getElementById('enddate').type = 'hidden';
        document.getElementById('enddatetext').style.display = "none";
        document.getElementById('actid').style.visibility = 'visible';
        document.getElementById('idtext').style.display = "inline";
        document.getElementById('sub').onclick = GetActDetailJson;
    }
    if (x == "ACT" && y == "sum") {
        document.getElementById('period').type = 'hidden';
        document.getElementById('periodtext').style.display = "none";
        document.getElementById('starttime').type = 'hidden';
        document.getElementById('stimetext').style.display = "none";
        document.getElementById('edtime').type = 'hidden';
        document.getElementById('edtimetext').style.display = "none";
        document.getElementById('enddate').type = 'hidden';
        document.getElementById('enddatetext').style.display = "none";
        document.getElementById('actid').style.visibility = 'hidden';
        document.getElementById('idtext').style.display = "none";
        document.getElementById('sub').onclick = GetActSumJson;
    }

    /**/
}
