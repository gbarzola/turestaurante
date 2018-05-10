<?php

  require_once 'DBOperations.php';

  class Functions{

  private $db;

  public function __construct() {

        $this -> db = new DBOperations();

  }


  public function registerUser($name, $email, $password) {

  	$db = $this -> db;

  	if (!empty($name) && !empty($email) && !empty($password)) {

    		if ($db -> checkUserExist($email)) {

    			$response["result"] = "failure";
    			$response["message"] = "Usuario ya registrado!";
    			return json_encode($response);

    		} else {

    			$result = $db -> insertData($name, $email, $password);

    			if ($result) {

  				  $response["result"] = "success";
    				$response["message"] = "Usuario registrado con éxito!";
    				return json_encode($response);
    						
    			} else {

    				$response["result"] = "failure";
    				$response["message"] = "Error al registrar";
    				return json_encode($response);

    			}
    		}					
    	} else {

    		return $this -> getMsgParamNotEmpty();

    	}
  }

  public function registerReservation2($iddish, $iduser) {

    $db = $this -> db;

    if (!empty($iddish) && !empty($iduser)) {

            $result = $db -> insertDataReservation($iddish, $iduser);

              if ($result) {

                $response["result"] = "success";
                $response["message"] = "Reserva registrado con éxito!";
                return json_encode($response);
                    
              } else {

                $response["result"] = "failure";
                $response["message"] = "Error al registrar la reserva";
                return json_encode($response);
              }
               
      } else {

        return $this -> getMsgParamNotEmpty();

      }
  }

  public function registerReservation($iddish, $iduser, $quantity) {

    $db = $this -> db;

    if (!empty($iddish) && !empty($iduser) && !empty($quantity)) {

          $val = $db -> valDishQuantity($iddish);

          if($val == "0"){

            $response["result"] = "failure";
            $response["message"] = 'No cuenta con stock';
            return json_encode($response);

          } elseif ($val < $quantity) {

            $response["result"] = "failure";
            $response["message"] = 'Stock insuficiente';
            return json_encode($response);

          }else{

            $quantity  = $val - $quantity;//Restar registros
            $resultUpt = $db -> updDishQuantity($iddish, $quantity);

            if($resultUpt == true){

              $result = $db -> insertDataReservation($iddish, $iduser);

              if ($result == true) {

                $response["result"] = "success";
                $response["message"] = "Reserva registrado con éxito!";
                return json_encode($response);
                    
              } else {

                $response["result"] = "failure";
                $response["message"] = "Error al registrar la reserva";
                return json_encode($response);
              }
            }elseif($resultUpt != true){
                $response["result"] = "failure";
                $response["message"] = "Error al actualizar stock";
                return json_encode($response);
            }
          }
               
      } else {

        return $this -> getMsgParamNotEmpty();

      }
  }

  public function updateDishQuantity($id, $quantity) {

    $db = $this -> db;

    if (!empty($id) && !empty($quantity)) {

      $val = $db -> valDishQuantity($id);      
          //$response["result"] = $val;
          //$response["message"] = 'test';
          //return json_encode($response);
      if($val == "0"){

        $response["result"] = "failure";
        $response["message"] = 'No cuenta con stock';
        return json_encode($response);

      } elseif ($val < $quantity) {

        $response["result"] = "failure";
        $response["message"] = 'Stock insuficiente';
        return json_encode($response);

      } else{

        $quantity = $val - $quantity;//Restar registros

        $result = $db -> updDishQuantity($id, $quantity);

        if($result) {

          $response["result"] = "success";
          $response["message"] = "Stock actualizado con éxito";
          return json_encode($response);

        } else {

          $response["result"] = "failure";
          $response["message"] = 'Error al actualizar el stock';
          return json_encode($response);

        }

      } 
    } else {

        return $this -> getMsgParamNotEmpty();
    }

  }

  public function getRestaurants(){
      $db = $this -> db;

      $result =  $db -> getRestaurant();


     if(!$result) {

      $response["result"] = "failure";
      $response["message"] = "No hay data por mostrar";
      return json_encode($response);

     } else {

      $response["result"] = "success";
      $response["message"] = "Lista de Restaurantes";
      $response["user"] = $result;
      return json_encode($response);

     }
  }

  public function getRestaurantsId($id){
      $db = $this -> db;

      if(!empty($id)){
        $result =  $db -> getRestaurantId($id);


         if(!$result) {

          $response["result"] = "failure";
          $response["message"] = "No hay data por mostrar";
          return json_encode($response);

         } else {

          $response["result"] = "success";
          $response["message"] = "Restaurant Encontrado";
          $response["user"] = $result;
          return json_encode($response);
         }  
      }else {

        return $this -> getMsgParamNotEmpty();
      }      
  }

  public function getDishesId($id_restaurant){
      $db = $this -> db;

      if(!empty($id_restaurant)){
        $result =  $db -> getDishId($id_restaurant);


         if(!$result) {

          $response["result"] = "failure";
          $response["message"] = "No hay platos registrados";
          return json_encode($response);

         } else {

          $response["result"] = "success";
          $response["message"] = "Platos encontrados";
          $response["data"] = $result;
          return json_encode($response);
         }  
      }else {

        return $this -> getMsgParamNotEmpty();
      }      
  }

  public function loginUser($email, $password) {

    $db = $this -> db;

    if (!empty($email) && !empty($password)) {

      if ($db -> checkUserExist($email)) {

         $result =  $db -> checkLogin($email, $password);


         if(!$result) {

          $response["result"] = "failure";
          $response["message"] = "Credenciales de acceso invalidos";
          return json_encode($response);

         } else {

          $response["result"] = "success";
          $response["message"] = "Inicio de sesión correcto";
          $response["user"] = $result;
          return json_encode($response);

         }

      } else {

        $response["result"] = "failure";
        $response["message"] = "Credenciales de acceso invalidos";
        return json_encode($response);

      }
    } else {

        return $this -> getMsgParamNotEmpty();
      }

  }


  public function changePassword($email, $old_password, $new_password) {

    $db = $this -> db;

    if (!empty($email) && !empty($old_password) && !empty($new_password)) {

      if(!$db -> checkLogin($email, $old_password)){

        $response["result"] = "failure";
        $response["message"] = 'Password anterior inválida';
        return json_encode($response);

      } else {


      $result = $db -> changePassword($email, $new_password);

        if($result) {

          $response["result"] = "success";
          $response["message"] = "Password cambiado con éxito";
          return json_encode($response);

        } else {

          $response["result"] = "failure";
          $response["message"] = 'Error al actualizar el Password';
          return json_encode($response);

        }

      } 
    } else {

        return $this -> getMsgParamNotEmpty();
    }

  }


  public function isEmailValid($email){

    return filter_var($email, FILTER_VALIDATE_EMAIL);
  }

  public function getMsgParamNotEmpty(){


    $response["result"] = "failure";
    $response["message"] = "Los parámetros no deberían estar vacíos!";
    return json_encode($response);
  }

  public function getMsgInvalidApi(){


    $response["result"] = "failure";
    $response["message"] = "Invocación incorrecta a API";
    return json_encode($response);
  }

  public function getMsgInvalidParam(){

    $response["result"] = "failure";
    $response["message"] = "Parámetros inválidos";
    return json_encode($response);

  }

  public function getMsgInvalidEmail(){

    $response["result"] = "failure";
    $response["message"] = "Email inválido";
    return json_encode($response);
  }

}
