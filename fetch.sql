
 SELECT 
	* 
FROM 
	learningprocess.homework h 

 SELECT 
*
FROM 
	learningprocess.lesson l
INNER JOIN
	learningprocess.homework h 
ON 
	l.homework_id = h.id  

 SELECT 
*
FROM 
	learningprocess.lesson l
INNER JOIN
	learningprocess.homework h 
ON 
	l.homework_id = h.id  
ORDER BY 
  l.updatedAt DESC 

 SELECT 
*
FROM 
	learningprocess.schedule s
Inner Join
	learningprocess.scheduled_lessons sl
On 
	s.id = sl.schedule_id
Inner Join
	learningprocess.lesson l
On 
	l.id = sl.lesson_id

 SELECT  
	s.name, COUNT(sl.lesson_id) AS l_count
FROM 
	learningprocess.schedule s
Inner Join
	learningprocess.scheduled_lessons sl
On 
	s.id = sl.schedule_id
GROUP BY 
	sl.schedule_id
ORDER BY
	s.name
