# <b>VB.net:</b>

## database connection 

- Etablire un Connection

```    
Dim connection As New SqlConnection("Data Source=WIN-2Q8UVVCMN3C\SQLEXPRESS;Initial Catalog=Gestion_Stock;Integrated Security=True")
```
#
- Executer une requette sql
#

_affecher liste des ventes dans un datagridview_

```
 Try
	connection.Open()
    Dim query As New SqlCommand("SELECT * FROM vente;", connection)
    Dim reader As SqlDataReader = query.ExecuteReader
    Dim table As New DataTable
    table.Load(reader)
    DGVListe.DataSource = table
    reader.Close()
Catch ex As Exception
    MsgBox(ex.Message)
End Try
connection.Close()
```

_*ajouter des valeur dans la table vente*_
```
 Try
	connection.Open()
    Dim query As New SqlCommand("INSERT INTO vente VALUES(" & CInt(id_vente.Text) & ", '" & CDate(dtp_vente.Text) & "', " & CInt(qte_vente.Text) & ", " & CDbl(pu_vente_vente.Text) & ", '" & mouvement_vente.Text & "', '" & profit_vente.Text & "', " & CInt(id_produit_vente.Text) & ", " & CInt(id_client_vente.Text) & ", " & CInt(id_admin_vente.Text) & ", '" & note_vente_text.Text & "');", connection)
    query.ExecuteNonQuery()
 Catch ex As Exception
    MsgBox(ex.Message)
 End Try 
 connection.Close()
```

_*modifier les valeur d'un produit par id passer en argument*_

```
	Try
		connection.Open()
		Dim requette As String = "UPDATE produits SET pu_prod = " & CDbl(prix_prod_text.Text) & " , prix_vente = " & CDbl(prix_v_text.Text) & ", note_client = '" & note_prod_text.Text & "', code_barre = '" & code_barre_prod.Text & "' WHERE id_prod = " & CInt(id_prod_text.Text) & " ;"

		Dim query As New SqlCommand(requette, connection)
		query.ExecuteNonQuery()
	Catch ex As Exception
		MsgBox(ex.Message)
	End Try
	connection.Close()
```



