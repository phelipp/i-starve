package pndtech.com.istarve.Data.percistence;

import java.util.List;

public interface Percistence <E extends ObjectPercistence>{
    List<E> get();
    E getIndex(int position);



}
