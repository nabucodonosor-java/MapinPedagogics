INSERT INTO tb_user (enrollment_Date, img_Url, name, email, password) VALUES 
(TIMESTAMP WITH TIME ZONE '2020-11-20T03:00:00Z', 'https://mapin-pedagogics.s3.sa-east-1.amazonaws.com/user-padrao.png', 'Aluno Teste',
'aluno@mapin.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_user (enrollment_Date, img_Url, name, email, password) VALUES 
(TIMESTAMP WITH TIME ZONE '2020-10-20T03:00:00Z', 'https://mapin-pedagogics.s3.sa-east-1.amazonaws.com/user-padrao.png', 'Professor Teste',
'professor@mapin.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_user (enrollment_Date, img_Url, name, email, password) VALUES 
(TIMESTAMP WITH TIME ZONE '2020-09-20T03:00:00Z', 'https://mapin-pedagogics.s3.sa-east-1.amazonaws.com/user-padrao.png', 'Admin',
'admin@mapin.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role (authority) VALUES ('ROLE_STUDENT');
INSERT INTO tb_role (authority) VALUES ('ROLE_INSTRUCTOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 3);

INSERT INTO tb_teacher (img_Teacher_Url, name, resume) VALUES 
('https://mapin-pedagogics.s3.sa-east-1.amazonaws.com/franco.png', 'Franco Brasil', 'Desenvolvedor backend com Java');



INSERT INTO tb_trail (img_Trail_Url, name, description) VALUES 
('https://mapin-pedagogics.s3.sa-east-1.amazonaws.com/logo-java.png', 'Programação', 'Jogos de lógica, algoritmos & cia');



INSERT INTO tb_subject (name, img_Subject_Url, description, trail_id, teacher_id) VALUES 
('Java Programmimng', 'https://mapin-pedagogics.s3.sa-east-1.amazonaws.com/logo-java.png', 'Comentário 01 Teste teste teste teste', 1, 1);



INSERT INTO tb_topic (img_Topic_Url, title, description, subject_id) VALUES 
('https://mapin-pedagogics.s3.sa-east-1.amazonaws.com/logo-java.png', 'Java Orientação a Objetos', 
'Comentário 01 Teste teste teste teste', 1);



INSERT INTO tb_study_class (publication_Date, title, subtitle, video_Url, video_Time, finished, description, subject_id, topic_id) VALUES 
(TIMESTAMP WITH TIME ZONE '2020-09-20T03:00:00Z', 'Conhecendo o Java', 'Nesta aula conheceremos a linguagem Java. O que é JRE, JVM e JDK?',
'https://mapin-pedagogics.s3.sa-east-1.amazonaws.com/Instalando+Java.mp4', 5, true, 'Comentário 01 Teste teste teste teste', 1, 1);







INSERT INTO tb_student_study_class (student_id, study_class_id) VALUES (1, 1);
INSERT INTO tb_student_study_class (student_id, study_class_id) VALUES (2, 1);
INSERT INTO tb_student_study_class (student_id, study_class_id) VALUES (3, 1);