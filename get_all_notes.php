
<?php




$connection = mysqli_connect('localhost' , 'root' , '');
// selecting database
mysqli_select_db($connection , 'notes_sharing');

$result = mysqli_query($connection, "select * from notes  ");

while($r = mysqli_fetch_assoc($result))
	$output[] = $r;

   $response['result'] = $output;
   echo json_encode($response);



?>
