package utn.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;

import utn.DTO.BaseDTO;
import utn.entity.BaseEntity;

public abstract class BaseService <ENTITY extends BaseEntity, DTO extends BaseDTO>  implements IBaseService<DTO>{
	
	
	protected JpaRepository repository;
	protected Class dtoClass;
	protected Class entityClass;
	
	public BaseService(JpaRepository repository, Class dtoClass, Class entityClass) {
		this.repository = repository;
		this.dtoClass = dtoClass;
		this.entityClass = entityClass;
	}


	@Transactional
	public List<DTO> findAll() throws Exception {
		
		List<ENTITY> entities = repository.findAll();
		List<DTO> dtos = new ArrayList<>();
		
		try {
		
			ModelMapper modelMapper = new ModelMapper();
			
			for (ENTITY item : entities) {
				
				DTO dto = (DTO) modelMapper.map(item, dtoClass);
				dtos.add(dto);
				
			}
		
		} catch (Exception e) {
			
			throw new Exception();
			
		}
		
		return dtos;
	}

	@Transactional
	public DTO findById(int id) throws Exception {
		
		Optional<ENTITY> entityOptional = repository.findById(id);
		
		try {
			
			ENTITY entity = entityOptional.get();			
			ModelMapper modelMapper = new ModelMapper();			
			return (DTO) modelMapper.map(entity, dtoClass);
			
		} catch (Exception e) {
			
			throw new Exception();
			
		}
	}


	@Transactional
	public DTO save(DTO dto) throws Exception {
		
		ENTITY entity;
		ModelMapper modelMapper = new ModelMapper();
		
		try {
			
			entity = (ENTITY) modelMapper.map(dto, entityClass);
			entity = (ENTITY) repository.save(entity);//esta operacion tambien me devuelve el entity con ID incluido
			
			return (DTO) modelMapper.map(entity, dtoClass);			
			
		} catch (Exception e) {
			
			System.out.println(e);
			throw new Exception();
			
		}
	}


	@Transactional
	public DTO update(int id, DTO dto) throws Exception {
		
		Optional<ENTITY> entityOptional = repository.findById(id); //entity optional toma en cuenta obtener un null
		ModelMapper modelMapper = new ModelMapper();
		
		try {
			
			ENTITY entity = entityOptional.get();
			ENTITY entityParams = (ENTITY) modelMapper.map(dto, entityClass);
			
			try {
				
				if (repository.existsById(id)) {//este if puede quitarse, la exception la puede lanzar la clase optional
					
					entityParams.setId(id);
					entity = (ENTITY) repository.save(entityParams);
					return (DTO) modelMapper.map(entity, dtoClass);
					
				}
				else {
					
					throw new Exception();
					
				}
				
				
			} catch (Exception e) {
				
				throw new Exception();
				
			}
			
			
		} catch (Exception e) {
			
			throw new Exception();
			
		}
	}


	@Transactional
	public boolean delete(int id) throws Exception {
		
		try {
			
			if (repository.existsById(id)) {
				
				repository.deleteById(id);
				return true;
				
			}
			
			else {
				
				throw new Exception();
				
			}
			
		} catch (Exception e) {
			
			throw new Exception();
			
		}
	}
	
	
	
}
