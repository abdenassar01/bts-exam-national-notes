# PHP

- _method getConnection pour etablir une connection:_
```
    function getConnection(){
      $connection = mysqli_connect("server", "username", "password", "db_name");
    
      if (mysqli_connect_errno()){
        die(mysqli_connect_error());
      }
      return $connection;
    }
  ```

- _remplire un table avec lien hypertext_ 
```
    $result = mysqli_query($connection,"select * from formation")
    while($raw = mysqli_fetch_assoc($result)){
        echo "<tr>";
        echo "<td>".$raw['codeF']."</td>";
        echo "<td>".$raw['lielle']."</td>";
        echo "<td><a href='lstben.php?codeF=".$raw['codeF']."'>liste Beneficaires</a> </td>";
        echo "</tr>";
    }
```

- _remplire un table html utilisant code envoiyer par un lien hypertext:_ 

```
    $resultat = mysqli_query($connection, "Select * from client c inner join formation f on f.codef = c.codef where c.codef =".$_GET['codeF']);
    while ($raw = mysqli_fetch_assoc($resultat)){
        echo "<tr>";
        echo "<td>".$raw['code']."</td>";
        echo "<td>".$raw['nom']."</td>";
        echo "<td>".$raw['prenom']."</td>";
        echo "<td>".$raw['ville']."</td>";
        echo "<td>".$raw['tel']."</td>";
        echo "<td>".$raw['address']."</td>";
        echo "</tr>";
    }
```

