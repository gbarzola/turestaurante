<?php 

	require_once 'DbConnect.php';
	
	$response = array();
	
	if(isset($_GET['apicall'])){
		
		switch($_GET['apicall']){
			
			case 'signup':
				if(isTheseParametersAvailable(array('username','email','password','type'))){
					$username = $_POST['username']; 
					$email = $_POST['email']; 
					$password = md5($_POST['password']);
					$type = $_POST['type']; 
					
					$stmt = $conn->prepare("SELECT id FROM users WHERE username = ? OR email = ?");
					$stmt->bind_param("ss", $username, $email);
					$stmt->execute();
					$stmt->store_result();
					
					if($stmt->num_rows > 0){
						$response['error'] = true;
						$response['message'] = 'Usuario ya registrado';
						$stmt->close();
					}else{
						$stmt = $conn->prepare("INSERT INTO users (username, email, password, type) VALUES (?, ?, ?, ?)");
						$stmt->bind_param("ssss", $username, $email, $password, $type);

						if($stmt->execute()){
							$stmt = $conn->prepare("SELECT id, id, username, email, type FROM users WHERE username = ?"); 
							$stmt->bind_param("s",$username);
							$stmt->execute();
							$stmt->bind_result($userid, $id, $username, $email, $type);
							$stmt->fetch();
							
							$user = array(
								'id'=>$id, 
								'username'=>$username, 
								'email'=>$email,
								'type'=>$type
							);
							
							$stmt->close();
							
							$response['error'] = false; 
							$response['message'] = 'Usuario registrado con éxito'; 
							$response['user'] = $user; 
						}
					}
					
				}else{
					$response['error'] = true; 
					$response['message'] = 'Los parámetros requeridos no están disponibles'; 
				}
				
			break; 
			
			case 'login':
				
				if(isTheseParametersAvailable(array('username', 'password'))){
					
					$username = $_POST['username'];
					$password = md5($_POST['password']); 
					
					$stmt = $conn->prepare("SELECT id, username, email, type FROM users WHERE username = ? AND password = ?");
					$stmt->bind_param("ss",$username, $password);
					
					$stmt->execute();
					
					$stmt->store_result();
					
					if($stmt->num_rows > 0){
						
						$stmt->bind_result($id, $username, $email, $type);
						$stmt->fetch();
						
						$user = array(
							'id'=>$id, 
							'username'=>$username, 
							'email'=>$email,
							'type'=>$type
						);
						
						$response['error'] = false; 
						$response['message'] = 'Inicio de sesión satisfactorio'; 
						$response['user'] = $user; 
					}else{
						$response['error'] = false; 
						$response['message'] = 'Usuario o contraseña invalido';
					}
				}
			break; 

		case 'restaurant':
				
				if(isTheseParametersAvailable(array())){
					
					//$username = $_POST['username'];
					//$password = md5($_POST['password']); 
					
					$stmt = $conn->prepare("SELECT id, NAME, address, latitude, LENGTH, phone, cost_range, dni_suscritor FROM restaurant");
					//$stmt->bind_param("ss",$username, $password);
					
					$stmt->execute();
					
					$stmt->store_result();
					
					if($stmt->num_rows > 0){
						
						$stmt->bind_result($id, $NAME, $address, $latitude, $LENGTH, $phone, $cost_range, $dni_suscritor);
						$stmt->fetch();						

						$restaurant = array(
							'id'=>$id, 
							'NAME'=>$NAME, 
							'address'=>$address,
							'latitude'=>$latitude,
							'LENGTH'=>$LENGTH,
							'phone'=>$phone,
							'cost_range'=>$cost_range,
							'dni_suscritor'=>$dni_suscritor,
						);								

						$response['error'] = false; 
						$response['message'] = 'Resultado'; 
						$response['data'] = $restaurant; 
					}else{
						$response['error'] = false; 
						$response['message'] = 'No hay data a mostrar';
					}
				}
			break;
			
			default: 
				$response['error'] = true; 
				$response['message'] = 'Invocacion a operacion inválida';
		}
		
	}else{
		$response['error'] = true; 
		$response['message'] = 'API no válida';
	}
	
	echo json_encode($response);
	
	function isTheseParametersAvailable($params){
		
		foreach($params as $param){
			if(!isset($_POST[$param])){
				return false; 
			}
		}
		return true; 
	}
?>