create table suggest(
  num int ,
  word varchar2(100)
)

	    
insert into suggest values(1, 'Ajax');
insert into suggest values(2, 'Ajax ���� ���α׷���');
insert into suggest values(3, '�ڶ�');
insert into suggest values(4, '�ڹ�');
insert into suggest values(4, '�ڹ� ���α׷���');
insert into suggest values(5, '�ڹ� ���� ������');
insert into suggest values(6, '�����α׷���');
insert into suggest values(7, '��������');
insert into suggest values(8, '��������');
insert into suggest values(9, '�ڹٽ��͵�');
insert into suggest values(10, '�ڹ� ����');
insert into suggest values(11, '�� ĵ');



select word from suggest 
where lower(word) like lower('a%');



commit












