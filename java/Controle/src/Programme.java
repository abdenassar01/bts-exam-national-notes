import exceptions.ErrIndexException;

import java.util.ArrayList;

public class Programme {
    
    ArrayList<Emission> liste ;

    public Programme() {
        liste = new ArrayList<>();
    }
    
    public boolean addEmission(Emission e){
        return liste.add(e);
    }
    
    public Emission delEmission(int index) throws ErrIndexException{
        if(index < 0 && index > liste.size() ) {
            throw new ErrIndexException(index);
        }
        return liste.remove(index);
    }
    
    public boolean delEmission(Emission emission){
       return liste.remove(emission);
    }
    
    public Emission setEmission(int index, Emission emission)throws ErrIndexException {
        if(index < 0 && index > liste.size() ) {
            throw new ErrIndexException(index); 
        }
        return liste.set(index, emission);
    }

    @Override
    public String toString() {
        String str = "La Liste des Emissions est: ";
        
        for (Emission emission : liste) {
            str += "\n" + emission.getInfo();
        }
        return str;
    }
    
}
