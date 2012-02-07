/* 
 * Copyright 2011-2012 the original author or authors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.skydingo.skybase.repository;

import java.util.List;

import org.skydingo.skybase.model.Module;
import org.skydingo.skybase.model.Package;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 */
public interface PackageRepository extends GraphRepository<Package> {
	
//	/**
//	 * @param groupId
//	 * @param packageId
//	 * @param version
//	 * @return
//	 */
//	// http://stackoverflow.com/questions/8032979/cypher-query-to-get-nodes-with-given-property-values
//	List<Package> findByGroupIdAndPackageIdAndVersion(String groupId, String packageId, String version);
	
	/**
	 * @param module
	 * @return
	 */
	// FIXME This shouldn't need an explicit query, but for right now it does since Spring Data Neo4j can't handle it.
	@Query("start module=node({0}) match package-[:FROM_MODULE]->module return package")
	List<Package> findByModule(Module module);
	
	/**
	 * @param module
	 * @param version
	 * @return
	 */
	Package findByModuleAndVersion(Module module, String version);
}
