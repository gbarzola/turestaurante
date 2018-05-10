<?php

require_once 'Functions.php';

$fun = new Functions();


if ($_SERVER['REQUEST_METHOD'] == 'POST')
{
  $data = json_decode(file_get_contents("php://input"));

  if(isset($data -> operation)){

  	$operation = $data -> operation;

  	if(!empty($operation)){

  		if($operation == 'register'){

  			if(isset($data -> user ) && !empty($data -> user) && isset($data -> user -> name) 
  				&& isset($data -> user -> email) && isset($data -> user -> password)){

  				$user = $data -> user;
  				$name = $user -> name;
  				$email = $user -> email;
  				$password = $user -> password;

          if ($fun -> isEmailValid($email)) {
            
            echo $fun -> registerUser($name, $email, $password);

          } else {

            echo $fun -> getMsgInvalidEmail();
          }

  			} else {

  				echo $fun -> getMsgInvalidParam();

  			}

  		}else if($operation == 'insertreservation'){

        if(isset($data -> reservation) && !empty($data -> reservation) 
                                                                      && isset($data -> reservation -> iddish) 
                                                                      && isset($data -> reservation -> iduser)
                                                                      && isset($data -> reservation -> quantity)){

          $reservation = $data -> reservation;
          $iddish   = $reservation -> iddish;
          $iduser   = $reservation -> iduser;
          $quantity   = $reservation -> quantity;

          echo $fun -> registerReservation($iddish, $iduser, $quantity);

        } else {

          echo $fun -> getMsgInvalidParam();

        }

      }else if ($operation == 'login') {

        if(isset($data -> user ) && !empty($data -> user) && isset($data -> user -> email) && isset($data -> user -> password)){

          $user = $data -> user;
          $email = $user -> email;
          $password = $user -> password;

          echo $fun -> loginUser($email, $password);

        } else {

          echo $fun -> getMsgInvalidParam();

        }
      } else if ($operation == 'chgPass') {

        if(isset($data -> user ) && !empty($data -> user) && isset($data -> user -> email) && isset($data -> user -> old_password) 
          && isset($data -> user -> new_password)){

          $user = $data -> user;
          $email = $user -> email;
          $old_password = $user -> old_password;
          $new_password = $user -> new_password;

          echo $fun -> changePassword($email, $old_password, $new_password);

        } else {

          echo $fun -> getMsgInvalidParam();

        }
      }/*else if ($operation == 'uptStockDish') {

        if(isset($data -> reservation ) && !empty($data -> reservation) && isset($data -> reservation -> id) && isset($data -> reservation -> quantity)){

          $reservation = $data -> reservation;
          $id = $reservation -> id;
          $quantity = $reservation -> quantity;

          echo $fun -> updateDishQuantity($id, $quantity);

        } else {

          echo $fun -> getMsgInvalidParam();

        }
      }*/

  	}else{

  		
  		echo $fun -> getMsgParamNotEmpty();

  	}
  } else {

  		echo $fun -> getMsgInvalidParam();

  }
} else if ($_SERVER['REQUEST_METHOD'] == 'GET'){

  if(isset($_GET['apicall'])){
    
    switch($_GET['apicall']){
      case 'getrestaurant':
        echo $fun -> getRestaurants();
        break;

      case 'getrestaurantid':

        //if(isset($data -> id)){
          
          //$id = $data -> id;
          $id = $_GET["id"];
          echo $fun -> getRestaurantsId($id);

        //}else{
          //echo $fun -> getMsgInvalidParam();
        //}
        
        break;
      case 'getdishid':
          $id = $_GET["id"];
          echo $fun -> getDishesId($id);
        break;
    }

  }else{
      echo $fun -> getMsgInvalidApi();    
  }
  //echo "API";
  /*
  $data =  json_decode(file_get_contents("php://input"));

  if(isset($data -> operation)){
    $operation = $data -> operation;

    if(!empty($operation)){
      if($operation == "getRest"){
        echo $fun -> getRestaurants();
      }
    }else{
      echo $fun -> getMsgParamNotEmpty();
    }
  }else{
    echo $fun -> getMsgInvalidParam();
  }
  */
}

