
drop table bank;

create table bank(
   account varchar2(10) primary key, --���¹�ȣ
   balance number --�ܾ�
);--alt+x

 insert into bank values('A01',1000);
 insert into bank values('A02',500);
 
 select * from bank;
 
 commit


--������ü.
1. �����Ѵ�.
update bank set balance=balane-����ݾ� where account = ��ݰ��¹�ȣ;


2. ������ �ݾ׸�ŭ �Ա��Ѵ�.
update bank set balance=balance+����ݾ� where account =�Աݰ��¹�ȣ;

select balance from bank where account='A02';









