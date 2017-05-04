<?php

$data = file_get_contents('php://input');

$data_decoded = json_decode($data , true);


$email = $data_decoded['email_key'];
$password = $data_decoded['password_key'];

$connection = mysqli_connect('localhost' , 'root' , '');

// selecting database

mysqli_select_db($connection , 'notes_sharing');

$result = mysqli_query($connection, "select * from user where Email_id = '$email' and Password = '$password' ");

$rows = mysqli_num_rows($result);

if($rows > 0)

{
	
	$response['key'] = "done";
	
	$row = mysqli_fetch_array($result);
	
	$response['user_id'] = $row['User_id'];
	
	echo json_encode($response);
	
}

else {
	$response['key'] = "not done";
	
	echo json_encode($response);
	
}