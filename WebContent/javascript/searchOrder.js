$(document).ready(function(){

    $("#regOrderModal").click(function(){
        event.preventDefault();
        $("#modal1").modal();
    });

});

function searchNames() {
    var lableAvail = $('<h4> Available Clients </h4>');
    var radioBtn = $('<input type="radio" name="rbtnCount" />');
    var from_database = "Im from database"
    var label = $('<label for="contactChoice2">'+document.getElementById("searchOrder").value+'</label>')
    lableAvail.appendTo('#target');
    radioBtn.appendTo('#target');
    label.appendTo('#target');
}
