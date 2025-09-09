-- === Company Data ===
INSERT INTO company (companyid, name, industry, website) VALUES
(1, 'TechNova', 'Software', 'https://www.technova.com'),
(2, 'HealthPlus', 'Healthcare', 'https://www.healthplus.com'),
(3, 'FinEdge', 'Finance', 'https://www.finedge.com'),
(4, 'EduSmart', 'Education', 'https://www.edusmart.org'),
(5, 'GreenTech', 'Renewable Energy', 'https://www.greentech.io');

-- === Users (Recruiters + Job Seekers) ===
INSERT INTO users (userid, username, email, password, resumeurl, designation, lastlogin, role) VALUES
(1, 'alice', 'alice@technova.com', 'hashedpass1', NULL, 'HR Manager', NOW(), 'RECRUITER'),
(2, 'bob', 'bob@gmail.com', 'hashedpass2', 'resume_bob.pdf', 'Software Engineer', NULL, 'JOB_SEEKER'),
(3, 'charlie', 'charlie@healthplus.com', 'hashedpass3', NULL, 'Recruitment Lead', NOW(), 'RECRUITER'),
(4, 'diana', 'diana@yahoo.com', 'hashedpass4', 'resume_diana.pdf', 'Data Analyst', NULL, 'JOB_SEEKER'),
(5, 'eric', 'eric@finedge.com', 'hashedpass5', NULL, 'HR Associate', NOW(), 'RECRUITER'),
(6, 'frank', 'frank@gmail.com', 'hashedpass6', 'resume_frank.pdf', 'Full Stack Developer', NULL, 'JOB_SEEKER'),
(7, 'grace', 'grace@edusmart.org', 'hashedpass7', NULL, 'Recruiter', NOW(), 'RECRUITER'),
(8, 'helen', 'helen@yahoo.com', 'hashedpass8', 'resume_helen.pdf', 'Teacher', NULL, 'JOB_SEEKER'),
(9, 'ian', 'ian@greentech.io', 'hashedpass9', NULL, 'Talent Acquisition', NOW(), 'RECRUITER'),
(10, 'julia', 'julia@gmail.com', 'hashedpass10', 'resume_julia.pdf', 'Data Scientist', NULL, 'JOB_SEEKER');

-- === Skills ===
INSERT INTO skills (skillid, skillname) VALUES
(1, 'Java'),
(2, 'Spring Boot'),
(3, 'SQL'),
(4, 'Python'),
(5, 'Data Analysis'),
(6, 'Machine Learning'),
(7, 'React'),
(8, 'AWS'),
(9, 'Accounting'),
(10, 'Teaching');

-- === Jobs ===
INSERT INTO jobs (jobid, title, description, location, available, filled, companyid, userid, createdat) VALUES
(1, 'Backend Developer', 'Work on APIs and backend systems.', 'New York', 3, 0, 1, 1, NOW()),
(2, 'Data Analyst', 'Analyze healthcare datasets.', 'Boston', 2, 1, 2, 3, NOW()),
(3, 'Full Stack Developer', 'Work on frontend and backend.', 'San Francisco', 4, 0, 3, 5, NOW()),
(4, 'Teacher', 'Teach online courses.', 'Remote', 5, 1, 4, 7, NOW()),
(5, 'Sustainability Analyst', 'Analyze renewable projects.', 'Seattle', 2, 0, 5, 9, NOW()),
(6, 'Finance Analyst', 'Work on investment strategies.', 'Chicago', 3, 0, 3, 5, NOW()),
(7, 'Data Scientist', 'Work on ML models and data pipelines.', 'Austin', 2, 0, 1, 1, NOW());

-- === Job-Skills ===
INSERT INTO job_skills (jobid, skillid) VALUES
(1, 1), -- Backend Developer needs Java
(1, 2), -- Backend Developer needs Spring Boot
(1, 3), -- Backend Developer needs SQL
(2, 3), -- Data Analyst needs SQL
(2, 5), -- Data Analyst needs Data Analysis
(3, 1), -- Full Stack Developer needs Java
(3, 2), -- needs Spring Boot
(3, 7), -- needs React
(3, 8), -- needs AWS
(4, 10), -- Teacher needs Teaching
(5, 5), -- Sustainability Analyst needs Data Analysis
(5, 8), -- Sustainability Analyst needs AWS
(6, 3), -- Finance Analyst needs SQL
(6, 9), -- Finance Analyst needs Accounting
(7, 4), -- Data Scientist needs Python
(7, 6), -- Data Scientist needs Machine Learning
(7, 3); -- Data Scientist needs SQL

-- === User-Skills ===
INSERT INTO userskill (userid, skillid) VALUES
(2, 1), -- Bob knows Java
(2, 3), -- Bob knows SQL
(4, 3), -- Diana knows SQL
(4, 5), -- Diana knows Data Analysis
(6, 1), -- Frank knows Java
(6, 7), -- Frank knows React
(6, 8), -- Frank knows AWS
(8, 10), -- Helen knows Teaching
(10, 4), -- Julia knows Python
(10, 6), -- Julia knows Machine Learning
(10, 3), -- Julia knows SQL
(10, 8); -- Julia knows AWS

-- === Applications ===
INSERT INTO application (applicationid, jobid, userid, status, appliedat) VALUES
(1, 1, 2, 'PENDING', NOW()),  -- Bob applies for Backend Developer
(2, 2, 4, 'PENDING', NOW()), -- Diana applies for Data Analyst
(3, 3, 6, 'PENDING', NOW()),  -- Frank applies for Full Stack Developer
(4, 4, 8, 'ACCEPTED', NOW()), -- Helen applies for Teacher
(5, 5, 4, 'REJECTED', NOW()), -- Diana applies for Sustainability Analyst
(6, 6, 2, 'PENDING', NOW()),  -- Bob applies for Finance Analyst
(7, 7, 10, 'PENDING', NOW()), -- Julia applies for Data Scientist
(8, 1, 6, 'PENDING', NOW()),  -- Frank also applies for Backend Developer
(9, 2, 10, 'PENDING', NOW()); -- Julia applies for Data Analyst
