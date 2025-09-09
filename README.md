-- === Company Data ===
INSERT INTO company (companyid, name, industry, website) VALUES
(1, 'TechNova', 'Software', 'https://www.technova.com'),
(2, 'HealthPlus', 'Healthcare', 'https://www.healthplus.com');

-- === Users (Recruiters + Job Seekers) ===
INSERT INTO users (userid, username, email, password, resumeurl, designation, lastlogin, role) VALUES
(1, 'alice', 'alice@technova.com', 'hashedpass1', NULL, 'HR Manager', NOW(), 'RECRUITER'),
(2, 'bob', 'bob@gmail.com', 'hashedpass2', 'resume_bob.pdf', 'Software Engineer', NULL, 'JOB_SEEKER'),
(3, 'charlie', 'charlie@healthplus.com', 'hashedpass3', NULL, 'Recruitment Lead', NOW(), 'RECRUITER'),
(4, 'diana', 'diana@yahoo.com', 'hashedpass4', 'resume_diana.pdf', 'Data Analyst', NULL, 'JOB_SEEKER');

-- === Skills ===
INSERT INTO skills (skillid, skillname) VALUES
(1, 'Java'),
(2, 'Spring Boot'),
(3, 'SQL'),
(4, 'Python'),
(5, 'Data Analysis');

-- === Jobs ===
INSERT INTO jobs (jobid, title, description, location, available, filled, companyid, userid, createdat) VALUES
(1, 'Backend Developer', 'Work on APIs and backend systems.', 'New York', 3, 0, 1, 1, NOW()),
(2, 'Data Analyst', 'Analyze healthcare datasets.', 'Boston', 2, 1, 2, 3, NOW());

-- === Job-Skills ===
INSERT INTO job_skills (jobid, skillid) VALUES
(1, 1), -- Backend Developer needs Java
(1, 2), -- Backend Developer needs Spring Boot
(1, 3), -- Backend Developer needs SQL
(2, 3), -- Data Analyst needs SQL
(2, 5); -- Data Analyst needs Data Analysis

-- === User-Skills ===
INSERT INTO userskill (userid, skillid) VALUES
(2, 1), -- Bob knows Java
(2, 3), -- Bob knows SQL
(4, 3), -- Diana knows SQL
(4, 5); -- Diana knows Data Analysis

-- === Applications ===
INSERT INTO application (applicationid, jobid, userid, status, appliedat) VALUES
(1, 1, 2, 'PENDING', NOW()),  -- Bob applies for Backend Developer
(2, 2, 4, 'PENDING', NOW()); -- Diana applies for Data Analyst
