package br.com.gerenciadorcampeonatos.mappers;

import br.com.gerenciadorcampeonatos.dto.TimeDto;
import br.com.gerenciadorcampeonatos.modelo.Time;

public class TimeMapper {

    public static Time toEntity(TimeDto timeDto){
        Time time = new Time();
        
        time.setId(timeDto.getId());
        time.setNome(timeDto.getNome());
        
        return time;
        
    }
    
}
