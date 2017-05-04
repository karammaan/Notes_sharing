
<?php


$data = '{"user_id":"3"}';

$data_decoded = json_decode($data , true);

$user_id = $data_decoded['user_id'];

$connection = mysqli_connect('localhost' , 'root' , '');
// selecting database
mysqli_select_db($connection , 'notes_sharing');

$result = mysqli_query($connection, "select * from user where User_id = '3'  ");

while($r = mysqli_fetch_assoc($result))
	

   $response['result'] = $r;
   
   echo json_encode($response);



?>

