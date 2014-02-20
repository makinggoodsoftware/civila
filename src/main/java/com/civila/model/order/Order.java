package com.civila.model.order;


import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;

@JsonTypeInfo(
		use = JsonTypeInfo.Id.NAME,
		include= JsonTypeInfo.As.PROPERTY,
		property = "type"
)
@JsonSubTypes(
{
	@Type(value= NavigationRequest.class , name = "navigationRequest")
})
public interface Order {
}
