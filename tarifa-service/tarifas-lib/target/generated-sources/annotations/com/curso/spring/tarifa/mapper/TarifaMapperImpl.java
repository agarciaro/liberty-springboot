package com.curso.spring.tarifa.mapper;

import com.curso.spring.tarifa.entity.TarifaEntity;
import com.curso.spring.tarifa.model.Tarifa;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-07T12:54:06+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
public class TarifaMapperImpl implements TarifaMapper {

    @Override
    public Tarifa toDto(TarifaEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Long id = null;
        String nombre = null;
        BigDecimal importe = null;

        id = entity.getId();
        nombre = entity.getNombre();
        importe = entity.getImporte();

        Tarifa tarifa = new Tarifa( id, nombre, importe );

        return tarifa;
    }

    @Override
    public TarifaEntity toEntity(Tarifa dto) {
        if ( dto == null ) {
            return null;
        }

        TarifaEntity tarifaEntity = new TarifaEntity();

        tarifaEntity.setId( dto.getId() );
        tarifaEntity.setNombre( dto.getNombre() );
        tarifaEntity.setImporte( dto.getImporte() );

        return tarifaEntity;
    }

    @Override
    public List<Tarifa> toDto(List<TarifaEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<Tarifa> list = new ArrayList<Tarifa>( entities.size() );
        for ( TarifaEntity tarifaEntity : entities ) {
            list.add( toDto( tarifaEntity ) );
        }

        return list;
    }

    @Override
    public List<TarifaEntity> toEntity(List<Tarifa> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<TarifaEntity> list = new ArrayList<TarifaEntity>( dtos.size() );
        for ( Tarifa tarifa : dtos ) {
            list.add( toEntity( tarifa ) );
        }

        return list;
    }
}
