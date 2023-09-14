package kr.or.ddit.props.service;

import java.util.List;

import kr.or.ddit.vo.PropertyVO;

/**
 * Property 관리를 위한 Business Logic Layer
 *
 */
public interface PropertyService {
	 public boolean createProperty(PropertyVO prop);
	 public PropertyVO retrieveProperty(String propertyName);
	 public List<PropertyVO> retrieveProperties();
	 public boolean modifyProperty(PropertyVO prop);
	 public boolean removeProperty(String propertyName);
}
