$(document).ready(function(){
    $('[data-toggle="tooltip"]').tooltip();
    var actions = $("#table1 td:last-child").html();
    // Append table with add row
    $(".add-new").click(function(){      
        var index = $("#table1 tbody tr:last-child").index();
        var row = '<tr>' +
            '<td><select class="form-control" id="selector"> <option selected>Choose furniture...</option> <option id="kitchen">Kitchen</option> <option id="wardrobe">Wardrobe</option> <option id="door">Door</option> <option id="other">Other</option> </select></td>' +
            '<td><input type="text" id="status" class="form-control" name="phone" id="status"></td>' +
            '<td width="20%">' +
	           '<a class="edit" title="Edit" data-toggle="tooltip"><i class="material-icons">&#xE254;</i></a>' +
	           '<a class="delete" title="Delete" data-toggle="tooltip"><i class="material-icons">&#xE872;</i></a>' +
	           '</td>' +
            '<td>' + actions + '</td>' +
            '</tr>';
           
        $("#table1").append(row);     
        $("#table1 tbody tr").eq(index + 1).find(" .add").toggle();
        $('[data-toggle="tooltip"]').tooltip();
    });
	
    //Delete row
    $(document).on("click", ".delete", function(){
        $(this).parents("tr").remove();
        $(".add-new").removeAttr("disabled");
    });

});