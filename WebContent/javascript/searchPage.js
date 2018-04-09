$(document).ready(function(){

    $("#myBtn").click(function(){
        event.preventDefault();
        $("#myModal").modal();
    });


});

function searchNames() {
    var radioBtn = $('<input type="radio" name="rbtnCount" />');
    var from_database = "Im from database"
    var label = $('<label for="contactChoice2">'+document.getElementById("searchOrder").value+'</label>')
    radioBtn.appendTo('#target');
    label.appendTo('#target');
}
