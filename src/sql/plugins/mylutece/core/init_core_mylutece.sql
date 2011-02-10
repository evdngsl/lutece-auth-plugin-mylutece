--
-- Dumping data for table core_portlet_type
--
INSERT INTO core_portlet_type (id_portlet_type,name,url_creation,url_update,home_class,plugin_name,url_docreate,create_script,create_specific,create_specific_form,url_domodify,modify_script,modify_specific,modify_specific_form) VALUES 
 ('MYLUTECE_PORTLET','mylutece.portlet.name','plugins/mylutece/CreatePortletMyLutece.jsp','plugins/mylutece/ModifyPortletMyLutece.jsp','fr.paris.lutece.plugins.mylutece.business.portlet.MyLutecePortletHome','mylutece','plugins/mylutece/DoCreatePortletMyLutece.jsp','/admin/portlet/script_create_portlet.html','','','plugins/mylutece/DoModifyPortletMyLutece.jsp','/admin/portlet/script_modify_portlet.html','','');


--
-- Dumping data for table core_style
--
INSERT INTO core_style (id_style,description_style,id_portlet_type,id_portal_component) VALUES (200,'Défaut','MYLUTECE_PORTLET',0);


--
-- Dumping data for table core_style_mode_stylesheet
--
INSERT INTO core_style_mode_stylesheet (id_style,id_mode,id_stylesheet) VALUES (200,0,310);


--
-- Dumping data for table core_stylesheet
--
INSERT INTO core_stylesheet (id_stylesheet, description, file_name, source) VALUES (310,'Rubrique MyLutece - Défaut','portlet_mylutece.xsl',0x3C3F786D6C2076657273696F6E3D22312E30223F3E0D0A3C78736C3A7374796C6573686565742076657273696F6E3D22312E302220786D6C6E733A78736C3D22687474703A2F2F7777772E77332E6F72672F313939392F58534C2F5472616E73666F726D223E0D0A0D0A0D0A3C78736C3A74656D706C617465206D617463683D22706F72746C6574223E0D0A093C64697620636C6173733D22706F72746C6574202D6C75746563652D626F726465722D72616469757320617070656E642D626F74746F6D223E0D0A09093C78736C3A63686F6F73653E0D0A0920202020202020203C78736C3A7768656E20746573743D226E6F7428737472696E6728646973706C61792D706F72746C65742D7469746C65293D27312729223E0D0A090909093C683320636C6173733D22706F72746C65742D686561646572223E0D0A09090909093C78736C3A76616C75652D6F662064697361626C652D6F75747075742D6573636170696E673D22796573222073656C6563743D22706F72746C65742D6E616D6522202F3E0D0A090909093C2F68333E0D0A090909093C64697620636C6173733D22706F72746C65742D636F6E74656E74223E0D0A09090920202020093C78736C3A6170706C792D74656D706C617465732073656C6563743D226D796C75746563652D706F72746C657422202F3E0D0A090909093C2F6469763E0D0A0920202020202020203C2F78736C3A7768656E3E0D0A0920202020202020203C78736C3A6F74686572776973653E0D0A090909093C64697620636C6173733D22706F72746C65742D636F6E74656E74223E0D0A09090920202020093C78736C3A6170706C792D74656D706C617465732073656C6563743D226D796C75746563652D706F72746C657422202F3E0D0A090909093C2F6469763E0D0A0920202020202020203C2F78736C3A6F74686572776973653E0D0A09093C2F78736C3A63686F6F73653E0D0A093C2F6469763E0D0A3C2F78736C3A74656D706C6174653E0D0A0D0A0D0A3C78736C3A74656D706C617465206D617463683D226D796C75746563652D706F72746C6574223E0D0A093C78736C3A6170706C792D74656D706C617465732073656C6563743D22757365722D6E6F742D7369676E656422202F3E0D0A093C78736C3A6170706C792D74656D706C617465732073656C6563743D226C75746563652D7573657222202F3E0D0A3C2F78736C3A74656D706C6174653E0D0A0D0A0D0A3C78736C3A74656D706C617465206D617463683D22757365722D6E6F742D7369676E6564223E0D0A093C666F726D20616374696F6E3D226A73702F736974652F706C7567696E732F6D796C75746563652F446F4D794C75746563654C6F67696E2E6A737022206D6574686F643D22706F7374223E0D0A09090D0A09093C78736C3A6170706C792D74656D706C617465732073656C6563743D226C75746563652D757365722D61757468656E7469636174696F6E2D736572766963655B4064656C6567617465643D2774727565275D22202F3E0D0A09093C78736C3A6170706C792D74656D706C617465732073656C6563743D226C75746563652D757365722D61757468656E7469636174696F6E2D736572766963655B406C6F67696E70617373776F72642D72657175697265643D2774727565275D22202F3E0D0A09093C78736C3A696620746573743D22636F756E74286C75746563652D757365722D61757468656E7469636174696F6E2D736572766963655B406C6F67696E70617373776F72642D72657175697265643D2774727565275D29202667743B2031223E0D0A09093C63656E7465723E0D0A0909093C703E0D0A090909093C6C6162656C20666F723D22757365726E616D65223E436F6465206427616363C3A873203A3C2F6C6162656C3E0D0A090909093C696E707574206E616D653D22757365726E616D652220636C6173733D222D6C75746563652D696E707574202D6C75746563652D626F726465722D7261646975732D6D696E69222069643D22757365726E616D6522206175746F636F6D706C6574653D226F66662220746162696E6465783D22312220747970653D2274657874222F3E3C6272202F3E0D0A090909093C6C6162656C20666F723D2270617373776F7264223E4D6F74206465207061737365203A3C2F6C6162656C3E0D0A090909093C696E707574206E616D653D2270617373776F72642220636C6173733D222D6C75746563652D696E707574202D6C75746563652D626F726465722D7261646975732D6D696E69222069643D2270617373776F726422206175746F636F6D706C6574653D226F66662220746162696E6465783D22322220747970653D2270617373776F726422202F3E0D0A0909093C2F703E0D0A0909093C703E0D0A090909093C696E70757420636C6173733D222D6C75746563652D696E707574202D6C75746563652D626F726465722D7261646975732D6D696E6922202076616C75653D22436F6E6E6578696F6E2220746162696E6465783D22332220747970653D227375626D697422202F3E0D0A0909093C2F703E0D0A09093C2F63656E7465723E0D0A09093C2F78736C3A69663E0D0A093C2F666F726D3E0D0A093C78736C3A6170706C792D74656D706C617465732073656C6563743D226C75746563652D757365722D6E65772D6163636F756E742D75726C22202F3E0D0A093C78736C3A6170706C792D74656D706C617465732073656C6563743D226C75746563652D757365722D6C6F73742D70617373776F72642D75726C22202F3E0D0A3C2F78736C3A74656D706C6174653E0D0A0D0A3C78736C3A74656D706C617465206D617463683D226C75746563652D757365722D61757468656E7469636174696F6E2D736572766963655B406C6F67696E70617373776F72642D72657175697265643D2774727565275D223E0D0A093C63656E7465723E0D0A09093C696E70757420747970653D22726164696F22206E616D653D22617574685F70726F7669646572222076616C75653D227B6E616D657D22202F3E0D0A09093C696D67207372633D227B69636F6E2D75726C7D2220616C743D227B646973706C61792D6E616D657D22207469746C653D227B646973706C61792D6E616D657D222F3E26233136303B0D0A09093C78736C3A76616C75652D6F662073656C6563743D22646973706C61792D6E616D6522202F3E0D0A093C2F63656E7465723E0D0A3C2F78736C3A74656D706C6174653E0D0A0D0A3C78736C3A74656D706C617465206D617463683D226C75746563652D757365722D61757468656E7469636174696F6E2D736572766963655B4064656C6567617465643D2774727565275D223E0D0A093C63656E7465723E0D0A09093C6120687265663D227B75726C7D3F617574685F70726F76696465723D7B6E616D657D223E0D0A0909093C696D67207372633D227B69636F6E2D75726C7D2220616C743D227B646973706C61792D6E616D657D22207469746C653D227B646973706C61792D6E616D657D222F3E0D0A09093C2F613E0D0A093C2F63656E7465723E0D0A3C2F78736C3A74656D706C6174653E0D0A0D0A0D0A3C78736C3A74656D706C617465206D617463683D226C75746563652D75736572223E0D0A202020204269656E76656E75652020203C78736C3A76616C75652D6F662064697361626C652D6F75747075742D6573636170696E673D22796573222073656C6563743D226C75746563652D757365722D6E616D652D676976656E22202F3E26233136303B0D0A202020202020202020202020202020203C78736C3A76616C75652D6F662064697361626C652D6F75747075742D6573636170696E673D22796573222073656C6563743D226C75746563652D757365722D6E616D652D66616D696C7922202F3E0D0A202020203C6272202F3E0D0A202020203C6272202F3E0D0A202020203C78736C3A6170706C792D74656D706C617465732073656C6563743D226C75746563652D757365722D6C6F676F75742D75726C22202F3E0D0A202020203C78736C3A6170706C792D74656D706C617465732073656C6563743D226C75746563652D757365722D766965772D6163636F756E742D75726C22202F3E0D0A3C2F78736C3A74656D706C6174653E0D0A0D0A0D0A3C78736C3A74656D706C617465206D617463683D226C75746563652D757365722D6C6F676F75742D75726C223E0D0A2020203C666F726D206E616D653D226C6F676F75742220616374696F6E3D227B2E7D22206D6574686F643D22706F7374223E0D0A202020093C63656E7465723E0D0A09202020093C696E70757420747970653D227375626D6974222076616C75653D224426233233333B636F6E6E6578696F6E2220636C6173733D222D6C75746563652D696E707574202D6C75746563652D626F726465722D7261646975732D6D696E6922202F3E0D0A202020203C2F63656E7465723E0D0A2020203C2F666F726D3E0D0A3C2F78736C3A74656D706C6174653E0D0A0D0A0D0A3C78736C3A74656D706C617465206D617463683D226C75746563652D757365722D6E65772D6163636F756E742D75726C223E0D0A093C6469762069643D226C75746563652D757365722D6E65772D6163636F756E7422203E0D0A093C666F726D206E616D653D226C6F676F75742220616374696F6E3D227B2E7D22206D6574686F643D22706F7374223E0D0A20202020093C63656E7465723E0D0A0909202020093C696E70757420747970653D227375626D6974222076616C75653D22437226233233333B657220756E20636F6D7074652220636C6173733D222D6C75746563652D696E707574202D6C75746563652D626F726465722D7261646975732D6D696E6922202F3E0D0A09202020203C2F63656E7465723E0D0A202020203C2F666F726D3E0D0A202020203C2F6469763E0D0A3C2F78736C3A74656D706C6174653E0D0A0D0A0D0A3C78736C3A74656D706C617465206D617463683D226C75746563652D757365722D6C6F73742D70617373776F72642D75726C223E0D0A093C6469762069643D226C75746563652D757365722D6C6F73742D70617373776F726422203E0D0A09093C666F726D206E616D653D226C6F676F75742220616374696F6E3D227B2E7D22206D6574686F643D22706F7374223E0D0A0920202020093C63656E7465723E0D0A090909202020093C696E70757420747970653D227375626D6974222076616C75653D224D6F742064652070617373652070657264752220636C6173733D222D6C75746563652D696E707574202D6C75746563652D626F726465722D7261646975732D6D696E6922202F3E0D0A0909202020203C2F63656E7465723E0D0A092020203C2F666F726D3E0D0A2020203C2F6469763E0D0A3C2F78736C3A74656D706C6174653E0D0A0D0A3C78736C3A74656D706C617465206D617463683D226C75746563652D757365722D766965772D6163636F756E742D75726C223E0D0A093C666F726D206E616D653D226C6F676F75742220616374696F6E3D227B2E7D22206D6574686F643D22706F7374223E0D0A20202020093C63656E7465723E0D0A0909202020093C696E70757420747970653D227375626D6974222076616C75653D22566F6972206D6F6E20636F6D7074652220636C6173733D222D6C75746563652D696E707574202D6C75746563652D626F726465722D7261646975732D6D696E6922202F3E0D0A09202020203C2F63656E7465723E0D0A202020203C2F666F726D3E0D0A3C2F78736C3A74656D706C6174653E0D0A0D0A3C2F78736C3A7374796C6573686565743E0D0A0D0A);

--
-- Dumping data for table core_admin_role
--
INSERT INTO core_admin_role (role_key,role_description) VALUES ('assign_roles','Assigner des roles aux utilisateurs');
INSERT INTO core_admin_role (role_key,role_description) VALUES ('assign_groups','Assigner des groupes aux utilisateurs');


--
-- Dumping data for table core_admin_role_resource
--
INSERT INTO core_admin_role_resource (rbac_id,role_key,resource_type,resource_id,permission) VALUES 
 (205,'assign_roles','ROLE_TYPE','*','ASSIGN_ROLE');
INSERT INTO core_admin_role_resource (rbac_id,role_key,resource_type,resource_id,permission) VALUES 
 (206,'assign_groups','GROUP_TYPE','*','ASSIGN_GROUP');
INSERT INTO core_admin_role_resource (rbac_id,role_key,resource_type,resource_id,permission) VALUES 
 (207,'mylutece_manager','MYLUTECE','*','*');


--
-- Dumping data for table core_user_role
--
INSERT INTO core_user_role (role_key,id_user) VALUES ('assign_roles',1);
INSERT INTO core_user_role (role_key,id_user) VALUES ('assign_roles',2);
INSERT INTO core_user_role (role_key,id_user) VALUES ('assign_roles',3);
INSERT INTO core_user_role (role_key,id_user) VALUES ('assign_groups',1);
INSERT INTO core_user_role (role_key,id_user) VALUES ('assign_groups',2);
INSERT INTO core_user_role (role_key,id_user) VALUES ('assign_groups',3);

--
-- Dumping data for table core_admin_right
--
INSERT INTO core_admin_right VALUES ('MYLUTECE_MANAGEMENT', 'mylutece.adminFeature.mylutece_management.name', 2, 'jsp/admin/plugins/mylutece/attribute/ManageAttributes.jsp', 'mylutece.adminFeature.mylutece_management.description', 0, 'mylutece', 'USERS', NULL, NULL, NULL);

--
-- Dumping data for table core_user_right
--
INSERT INTO core_user_right (id_right,id_user) VALUES ('MYLUTECE_MANAGEMENT',1);
