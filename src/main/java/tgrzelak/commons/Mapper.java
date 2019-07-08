package tgrzelak.commons;

public interface Mapper<F, T>{

    T map(F from);
    F reverseMap (T to);

}
