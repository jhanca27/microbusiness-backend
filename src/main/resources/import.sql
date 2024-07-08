INSERT INTO countries(id, name) VALUES(1, 'Colombia')
INSERT INTO provinces(id, name, country_id) VALUES(1, 'Amazonas', 1);
INSERT INTO provinces(id, name, country_id) VALUES(2, 'Antioquia', 1);
INSERT INTO provinces(id, name, country_id) VALUES(3, 'Arauca', 1);
INSERT INTO provinces(id, name, country_id) VALUES(4, 'Atlántico', 1);
INSERT INTO provinces(id, name, country_id) VALUES(5, 'Bolívar', 1);
INSERT INTO provinces(id, name, country_id) VALUES(6, 'Boyacá', 1);
INSERT INTO provinces(id, name, country_id) VALUES(7, 'Caldas', 1);
INSERT INTO provinces(id, name, country_id) VALUES(8, 'Caquetá', 1);
INSERT INTO provinces(id, name, country_id) VALUES(9, 'Casanare', 1);
INSERT INTO provinces(id, name, country_id) VALUES(10, 'Cauca', 1);
INSERT INTO provinces(id, name, country_id) VALUES(11, 'Cesar', 1);
INSERT INTO provinces(id, name, country_id) VALUES(12, 'Chocó', 1);
INSERT INTO provinces(id, name, country_id) VALUES(13, 'Córdoba', 1);
INSERT INTO provinces(id, name, country_id) VALUES(14, 'Cundinamarca', 1);
INSERT INTO provinces(id, name, country_id) VALUES(15, 'Guainía', 1);
INSERT INTO provinces(id, name, country_id) VALUES(16, 'Guaviare', 1);
INSERT INTO provinces(id, name, country_id) VALUES(17, 'Huila', 1);
INSERT INTO provinces(id, name, country_id) VALUES(18, 'La Guajira', 1);
INSERT INTO provinces(id, name, country_id) VALUES(19, 'Magdalena', 1);
INSERT INTO provinces(id, name, country_id) VALUES(20, 'Meta', 1);
INSERT INTO provinces(id, name, country_id) VALUES(21, 'Nariño', 1);
INSERT INTO provinces(id, name, country_id) VALUES(22, 'Norte de Santander', 1);
INSERT INTO provinces(id, name, country_id) VALUES(23, 'Putumayo', 1);
INSERT INTO provinces(id, name, country_id) VALUES(24, 'Quindío', 1);
INSERT INTO provinces(id, name, country_id) VALUES(25, 'Risaralda', 1);
INSERT INTO provinces(id, name, country_id) VALUES(26, 'San Andrés y Providencia', 1);
INSERT INTO provinces(id, name, country_id) VALUES(27, 'Santander', 1);
INSERT INTO provinces(id, name, country_id) VALUES(28, 'Sucre', 1);
INSERT INTO provinces(id, name, country_id) VALUES(29, 'Tolima', 1);
INSERT INTO provinces(id, name, country_id) VALUES(30, 'Valle del Cauca', 1);
INSERT INTO provinces(id, name, country_id) VALUES(31, 'Vaupés', 1);
INSERT INTO provinces(id, name, country_id) VALUES(32, 'Vichada', 1);

INSERT INTO users(id, first_name, last_name, email, phone) VALUES(1, 'Jhan', 'Ca', 'jhan@gmail.com', "32516136513")
INSERT INTO users(id, first_name, last_name, email, phone) VALUES(2, 'Alice', 'Smith', 'alice.smith@example.com', '1234567890');
INSERT INTO users(id, first_name, last_name, email, phone) VALUES(3, 'Bob', 'Johnson', 'bob.johnson@example.com', '0987654321');
INSERT INTO users(id, first_name, last_name, email, phone) VALUES(4, 'Charlie', 'Brown', 'charlie.brown@example.com', '1112223333');
INSERT INTO users(id, first_name, last_name, email, phone) VALUES(5, 'Diana', 'Davis', 'diana.davis@example.com', '4445556666');
INSERT INTO users(id, first_name, last_name, email, phone) VALUES(6, 'Eve', 'Miller', 'eve.miller@example.com', '7778889999');
INSERT INTO users(id, first_name, last_name, email, phone) VALUES(7, 'Frank', 'Wilson', 'frank.wilson@example.com', '3332221111');
INSERT INTO users(id, first_name, last_name, email, phone) VALUES(8, 'Grace', 'Moore', 'grace.moore@example.com', '6665554444');
INSERT INTO users(id, first_name, last_name, email, phone) VALUES(9, 'Hank', 'Taylor', 'hank.taylor@example.com', '9998887777');
INSERT INTO users(id, first_name, last_name, email, phone) VALUES(10, 'Ivy', 'Anderson', 'ivy.anderson@example.com', '2223334445');

-- Insertar registros en la tabla micro_businesses

INSERT INTO micro_businesses(name, description, more_information, category, province_id, user_id) VALUES("EcoGreen Solutions", "Sustainable environmental solutions", "Offering eco-friendly products and services", "SOCIAL_ECONOMY", 1, 1);

INSERT INTO micro_businesses (name, description, more_information, category, province_id, user_id) VALUES("AgroHarvest Co.", "Innovative agricultural practices", "Promoting organic farming techniques", "AGROECOLOGY", 2, 2);

INSERT INTO micro_businesses (name, description, more_information, category, province_id, user_id) VALUES("ConserveNature", "Protecting natural habitats", "Programs for wildlife conservation", "CONSERVATION", 3, 3);

INSERT INTO micro_businesses (name, description, more_information, category, province_id, user_id) VALUES("Impact Innovators", "Business solutions for social good", "Consulting for sustainable development", "COMPANIES_IMPACT", 4, 4);

INSERT INTO micro_businesses (name, description, more_information, category, province_id, user_id) VALUES("GreenThumb Gardens", "Urban gardening and farming", "Workshops and supplies for urban agriculture", "SOCIAL_ECONOMY", 5, 5);

INSERT INTO micro_businesses (name, description, more_information, category, province_id, user_id) VALUES("BioFarm Enterprises", "Eco-friendly farming solutions", "Supporting local farmers with green technology", "AGROECOLOGY", 6, 6);

INSERT INTO micro_businesses (name, description, more_information, category, province_id, user_id) VALUES("Wildlife Warriors", "Wildlife protection initiatives", "Education and advocacy for endangered species", "CONSERVATION", 7, 7);

INSERT INTO micro_businesses (name, description, more_information, category, province_id, user_id) VALUES("Sustainable Futures", "Future-proof business practices", "Consulting for long-term sustainability", "COMPANIES_IMPACT", 8, 8);

INSERT INTO micro_businesses (name, description, more_information, category, province_id, user_id) VALUES("Nature Nurturers", "Environmental care and awareness", "Campaigns to increase environmental consciousness", "SOCIAL_ECONOMY", 9, 9);

INSERT INTO micro_businesses (name, description, more_information, category, province_id, user_id) VALUES("EcoFarm Solutions", "Advanced agricultural techniques", "Promoting sustainable farming methods", "AGROECOLOGY", 10, 10);

