INSERT INTO tb_user (enrollment_Date, img_User_Url, name, email, password) VALUES 
(TIMESTAMP WITH TIME ZONE '2020-11-20T03:00:00Z', 'https://mapin-pedagogics.s3.sa-east-1.amazonaws.com/user-padrao.png', 'Aluno Teste',
'aluno@mapin.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_user (enrollment_Date, img_User_Url, name, email, password) VALUES 
(TIMESTAMP WITH TIME ZONE '2020-10-20T03:00:00Z', 'https://mapin-pedagogics.s3.sa-east-1.amazonaws.com/user-padrao.png', 'Professor Teste',
'professor@mapin.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_user (enrollment_Date, img_User_Url, name, email, password) VALUES 
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
('Orientação a Objetos', 'https://mapin-pedagogics.s3.sa-east-1.amazonaws.com/logo-java.png', 'Comentário 01 Teste teste teste teste', 1, 1);

INSERT INTO tb_study_class (publication_Date, img_Study_Class_Url, title, subtitle, video_Url, video_Time, finisihed, description, subject_id, topic_id) VALUES 
(TIMESTAMP WITH TIME ZONE '2020-09-20T03:00:00Z', 'Comentário 01 Teste teste teste teste', 'Admin',
'admin@mapin.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_comment (publication_Date, comment, study_class_id, student_id) VALUES 
(TIMESTAMP WITH TIME ZONE '2020-09-20T03:00:00Z', 'Comentário 01 Teste teste teste teste', 'Admin',
'admin@mapin.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');