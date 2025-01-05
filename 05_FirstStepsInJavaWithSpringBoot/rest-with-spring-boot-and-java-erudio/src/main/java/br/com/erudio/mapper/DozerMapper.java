package br.com.erudio.mapper;

import java.util.ArrayList;
import java.util.List;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

/**
 * Classe converte entidades para VO's
 */

public class DozerMapper {

	private static Mapper mapper = DozerBeanMapperBuilder.buildDefault(); //Mapper =  usado para mapear propriedades entre dois objetos
	//DozerBeanMapperBuilder.buildDefault(): Cria uma instância padrão do mapeador Dozer. Ele é configurado automaticamente para mapear objetos que compartilham atributos com os mesmos nomes.
	
	//convercao (Origem, Destino - retorna destino
	public static <O, D> D parseObject(O origin, Class<D> destination) {
		return mapper.map(origin, destination);
	}
	
	//converte lista de objetos da classe de origem para classe de destino
	public static <O, D> List<D> parseListObjects(List<O> origin, Class<D> destination) {
		
		List<D> destinationObjects = new ArrayList<D>();
		//iterando sobre cada objeto da lista de origem
		for (O o : origin) {
			destinationObjects.add(mapper.map(o, destination)); //convertendo objetos da lista de origem "mapper" e adicionando o resultado na lista de destino
		}
		
		return destinationObjects;
	}
	
}
