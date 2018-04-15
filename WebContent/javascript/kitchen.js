$(document).ready(function(){
    $('[data-toggle="tooltip"]').tooltip();
    var actions = $("#table1 td:last-child").html();
    // Append table with add row
    $(".add-new").click(function(){      
        var index = $("#table1 tbody tr:last-child").index();
        var row = '<tr>' +
            '<td><input type="text" class="form-control" id="box" name="box_name"></td>' +
            '<td><input class="form-control" type="text" id="height" name="box_height"></td>' +
            '<td><input class="form-control" type="text" id="width" name="box_width"></td>' +
            '<td><input class="form-control" type="text" id="depth" name="box_depth"></td>' +
            '<td><input class="form-control" type="text" id="depth" name="box_num_shelves" value="0"></td>' +
            '<td><input type="text" class="form-control" id="melMat" name="box_colour"></td>' +
            '<td><input type="text" class="form-control" id="doorColour" name="door_colour"></td>' +
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