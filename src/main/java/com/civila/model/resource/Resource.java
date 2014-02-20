package com.civila.model.resource;

import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonTypeInfo;

@JsonTypeInfo(
	use = JsonTypeInfo.Id.NAME,
	include= JsonTypeInfo.As.PROPERTY,
	property = "resourceType"
)
@JsonSubTypes(
{
	@JsonSubTypes.Type(value= Information.class , name = "information"),
	@JsonSubTypes.Type(value= Merchant.class , name = "merchant")
})
public interface Resource {
	ResourceType getResourceType();

	String getDescription();
}
