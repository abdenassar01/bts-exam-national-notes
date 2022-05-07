# Exception:

## Class d’exeption personnel
#

```
public class ErrIndexException extends Exception{
    
    public ErrIndexException(String msg){
        System.out.println(msg);
    }
}
```

## Methode qui gere un exception:

```
public Emission delEmission(int index) throws ErrIndexException{
     if(index < 0 && index > liste.size() ) {
        throw new ErrIndexException(index);
     }
   return liste.remove(index);
}
```

## Catch exception:

```

public static void main(String[] args) {
        
  try{
       delEmission(1);
  }catch(ErrIndexException e){
     e.printStackTrace();
  }
}

```

## Charger un liste a partir d’un fichier

```
    public void loadData(String nomFile) throws Exception {
        ObjectInputStream in =
                new ObjectInputStream(
                        new FileInputStream(nomFile));
        listeSolutions.clear();
        while(true) {
            try{
                listeSolutions.add((Solution) in.readObject()); 
            }catch (Exception exception){
               break; 
            }
        }
        in.close();
    }
    
```

## Enregistrer dans un fichier avec condition prix supperieur a 300  
```
public void saveSolutions(String nomFile) throws Exception {
    ObjectOutputStream out =
            new ObjectOutputStream(
                    new FileOutputStream(nomFile));
    for(Solution solution : listeSolutions) {
        if(solution.getPrix() > 300){
            out.writeObject(solution);
            out.flush();
        }
    }
    out.close();
}
```

## Les methodes arraylist
```
    public boolean addSolution(Solution solution){
        return listeSolutions.add(solution);
    }
    
    public Solution delSolution(int index){
        if(index < 0 || index > listeSolutions.size()) {
            return null;
        }
        return listeSolutions.remove(index);
    } 
    
    public boolean delSolution(Object obj){
        Solution solution = (Solution) obj;
        
        return listeSolutions.remove(solution);
    }
    
    public int searchSolution(Solution s){
        return listeSolutions.indexOf(s);
    }

```

## _equals()_

```

```