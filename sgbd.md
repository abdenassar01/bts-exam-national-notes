# <b>SGBD</b>

-  _creation de la base de donnee_

```
CREATE DATABASE db_Nom
ON PRIMARY 
 (
	NAME = 'fichier_logique', 
	FILENAME = 'D:\Regie\Data\fichier_logique.mdf', 
	SIZE = 5MB, 
	MAXSIZE = 1 GB, 
	FILEGROWTH = 5%
)
LOG ON 
( 
	NAME = 'fichier_journale' , 
	FILENAME = 'D:\DataBases\fichier_journale.ldf', 
	SIZE = 5MB,
	MAXSIZE = UNLIMITED, 
	FILEGROWTH = 10MB 
)
GO;

```

- _creation des tables avec les contrants_
```
CREATE TABLE ABONNEMENT (Reference varchar(20) PRIMARY KEY,
	Entreprise INT,
	Etat_Abonnement varchar(50) CHECK (Etat_Abonnement IN ('En cours', 'Cl�tur�', 'Annul�')),
	Constraint FK_Ent_Ab Foreign Key (Entreprise) References Entreprise(Id_Client));

CREATE TABLE COMPTEUR (Ref_Compteur int Primary Key, Ref_Abn varchar(20), 
	Date_installation Date, Marque varchar(150),
	Etat_Compteur varchar(50) CHECK(Etat_Compteur IN ('service', 'Hors service')),
	Constraint FK_Cmp_Ab Foreign Key (Ref_Abn) References ABONNEMENT(Reference));
```
- _fonction qui prend an parametre et retourne an valeur_
```
Create function Fn_trouver_Abonn�(@Ref as varchar(20)) returns varchar(50) AS
	BEGIN
		DECLARE @RS varchar(50), @ID INT
		Select @ID = Entreprise From ABONNEMENT Where Reference = @Ref
		SELECT @RS = Raison_sociale From ENTREPRISE where Id_Client = @ID
		RETURN @RS
	END

--4- procedure prend an argument et afficher liste des element

Create proc Sp_Liste_Index ( @Ref As varchar(20) ) AS
	BEGIN
		If Exists (Select * From RELEVE Where Compteur=@Ref)
			Select Date_Releve, Index_Releve From RELEVE Where Compteur =@Ref
		Else
			print('ce Compteur n''existe pas')
	END
```
- _fonction retourne un table_
```
Create function fn_Nb_Reparations (@N_Cont int)
	Returns @T_Containeur Table (Volume Float,Nbre Int) 
	As
	Begin
		declare @V Float, @nb int;

		select @V = Largeur * Longueur * Hauteur From Containeur Where 
		 Num_Containeur = @N_Cont;

		Select @nb = Count(*), N_Containeur From Reparation
		Where N_Containeur = @N_ContGroup by N_Containeur;

		Insert into @T_Containeur values (@V , @nb);
		Return;
	End
```
- _D�crire en quelques lignes une solution technique pour automatiser la mise en �uvre d'une contrant:_
 - a: 
	 **Creation d'un Trigger qui doit se d�clencher avant l'insertion et la mise a jour d'une saisie dans la table <<ORDRE_LIVRAISON>> afin de verifier que la date de livraison est anterieure (superieure) a la date d'ordre ou creation une contrainte check sur le champ "date_livraison".** 
 - b: 
  ```
	CREATE TRIGGER Verifier_Date ON ORDRE_LIVRAISON
		FOR insert,update AS
		BEGIN
			DECLARE @date_Livraison date, @date_ordre DATE
				Select @date_Livraison = date_Livraison From inserted;
				select @date_ordre = date_ordre From ORDRE_LIVRAISONO,inserted I
				Where O.num_ordre = inserted.num_ordre;
			if(DATEDIFF(day,@date_ordre,@date_Livraison) < 0)
				Begin
					print('La date de livraison ne peut pas �tre avant la date d�ordre');
					Rollback;
				End
		END
```

-  _cr�ation du trigger qui permet d�interdire la suppression d�un client qui a au moins un ordre de livraison_
  
```
CREATE TRIGGER Tr_Verifier on ORDRE_LIVRAISON
FOR delete AS
	BEGIN
		DECLARE @ID_Clt INT
		Select @ID_Clt = Id_Client From deleted 
		IF exists(SELECT * FROM Ordre_Livraison WHERE id_client = @ID_Clt)
	BEGIN
		RollBack;
	END
END
```