package ra.restapi_crud.mapper;

public interface GenericMapper<E, R, S> {
    //1. Convert request to entity
    E mapperRequestToEntity(R r);

    //2. Convert entity to response
    S mapperEntityToResponse(E e);
}
