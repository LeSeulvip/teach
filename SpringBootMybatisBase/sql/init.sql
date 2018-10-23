
use SpringBootMybatisBase;

truncate table TbConfig;
truncate table TbUSer;
truncate table TbToken;
truncate table TbTokenInfo;


/*系统配置数据*/
insert into TbConfig(configKey,configValue,lastupdate) values('token.timeout','30',now());

/*默认测试用户*/
insert into TbUser(username,password,nickname) values('test','test-pwd','测试用户');

/*查询*/
select configKey,configValue, lastupdate from TbConfig;
select username,password,nickname,isEnable,regDate from TbUSer;
select token,uid,lastupdate from TbToken;
select token infoKey,info,lastupdate from TbTokenInfo;