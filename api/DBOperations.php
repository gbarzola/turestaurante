<?php

class DBOperations{

	 private $host = 'localhost';
	 private $user = 'root';
	 private $db = 'restaurant';
	 private $pass = '';
	 private $conn;

public function __construct() {

	$this -> conn = new PDO("mysql:host=".$this -> host.";dbname=".$this -> db, $this -> user, $this -> pass);

}
 
 public function insertDataReservation($iddish,$iduser){
    //$id_reservation = uniqid('', true);
    $sql = 'INSERT INTO reservation SET iddish =:iddish, iduser =:iduser, created_at = NOW()';

    $query = $this ->conn ->prepare($sql);
    $query->execute(array(':iddish' => $iddish, ':iduser' => $iduser));

    if ($query) {
        
        return true;

    } else {

        return false;

    }
 }


 public function insertData($name,$email,$password){

 	$unique_id = uniqid('', true);
    $hash = $this->getHash($password);
    $encrypted_password = $hash["encrypted"];
	$salt = $hash["salt"];

 	$sql = 'INSERT INTO user SET unique_id =:unique_id,name =:name,
    email =:email,encrypted_password =:encrypted_password,salt =:salt,created_at = NOW()';

 	$query = $this ->conn ->prepare($sql);
 	$query->execute(array('unique_id' => $unique_id, ':name' => $name, ':email' => $email,
     ':encrypted_password' => $encrypted_password, ':salt' => $salt));

    if ($query) {
        
        return true;

    } else {

        return false;

    }
 }

 public function getRestaurant(){
    $sql = "SELECT id, name, address, cost_range FROM restaurant";
    $query = $this -> conn -> prepare($sql);
    $query -> execute();
    //$data = $query -> fetchObject();
    
    $restaurants = array();
    while ($date = $query->fetchObject(__CLASS__)) {

        $res = array();
        $res["id"] = $date -> id;
        $res["name"] = $date -> name;
        $res["address"] = $date -> address;
        $res["cost_range"] = $date -> cost_range;

        array_push($restaurants, $res); 
    }
        
    return $restaurants;

 }

 public function getRestaurantId($id){
    //$sql = "SELECT id, name, address, cost_range FROM restaurant WHERE id BETWEEN ($id+0) AND ($id+10)";
    $sql = "SELECT id, name, address, cost_range FROM restaurant WHERE id = $id";
    $query = $this -> conn -> prepare($sql);
    $query -> execute();
    //$data = $query -> fetchObject();
    
    $restaurants = array();
    while ($date = $query->fetchObject(__CLASS__)) {

        $res = array();
        $res["id"] = $date -> id;
        $res["name"] = $date -> name;
        $res["address"] = $date -> address;
        $res["cost_range"] = $date -> cost_range;

        array_push($restaurants, $res); 
    }
        
    return $restaurants;
 }

 public function getDishId($id_restaurant){

    $sql = "SELECT  id, dish, cost, quantity, image_path FROM dish WHERE id_restaurant = $id_restaurant";
    $query = $this -> conn -> prepare($sql);
    $query -> execute();
    
    $dishes = array();
    while ($date = $query->fetchObject(__CLASS__)) {

        $dish = array();
        $dish["id"] = $date -> id;
        $dish["dish"] = $date -> dish;
        $dish["cost"] = $date -> cost;
        $dish["quantity"] = $date -> quantity;
        $dish["image_path"] = $date -> image_path;

        array_push($dishes, $dish); 
    }
        
    return $dishes;
 }


 public function checkLogin($email, $password) {

    $sql = 'SELECT * FROM user WHERE email = :email';
    $query = $this -> conn -> prepare($sql);
    $query -> execute(array(':email' => $email));
    $data = $query -> fetchObject();
    $salt = $data -> salt;
    $db_encrypted_password = $data -> encrypted_password;

    if ($this -> verifyHash($password.$salt,$db_encrypted_password) ) {


        $user["name"] = $data -> name;
        $user["email"] = $data -> email;
        $user["unique_id"] = $data -> unique_id;
        return $user;

    } else {

        return false;
    }

 }

 public function changePassword($email, $password){


    $hash = $this -> getHash($password);
    $encrypted_password = $hash["encrypted"];
    $salt = $hash["salt"];

    $sql = 'UPDATE user SET encrypted_password = :encrypted_password, salt = :salt WHERE email = :email';
    $query = $this -> conn -> prepare($sql);
    $query -> execute(array(':email' => $email, ':encrypted_password' => $encrypted_password, ':salt' => $salt));

    if ($query) {
        
        return true;

    } else {

        return false;

    }

 }

  public function updDishQuantity($id, $quantity){

    $sql = 'UPDATE dish SET quantity = :quantity WHERE id = :id';
    $query = $this -> conn -> prepare($sql);
    $query -> execute(array(':id' => $id, ':quantity' => $quantity));

    if ($query) {
        
        return true;

    } else {

        return false;

    }

 }

public function valDishQuantity($id){

    $sql = 'SELECT quantity from dish WHERE id =:id';
    $query = $this -> conn -> prepare($sql);
    $query -> execute(array('id' => $id));

    if($query){

        $quantity = $query -> fetchColumn();

        if ($quantity == 0){

            return 0;

        } else {

            return $quantity;

        }
    } else {

        return false;
    }
 }

 public function checkUserExist($email){

    $sql = 'SELECT COUNT(*) from user WHERE email =:email';
    $query = $this -> conn -> prepare($sql);
    $query -> execute(array('email' => $email));

    if($query){

        $row_count = $query -> fetchColumn();

        if ($row_count == 0){

            return false;

        } else {

            return true;

        }
    } else {

        return false;
    }
 }

 public function getHash($password) {

     $salt = sha1(rand());
     $salt = substr($salt, 0, 10);
     $encrypted = password_hash($password.$salt, PASSWORD_DEFAULT);
     $hash = array("salt" => $salt, "encrypted" => $encrypted);

     return $hash;

}



public function verifyHash($password, $hash) {

    return password_verify ($password, $hash);
}



}




