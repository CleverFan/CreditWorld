CREATE DATABASE IF NOT EXISTS credit;

USE credit;

DROP TABLE IF EXISTS USER;
DROP TABLE IF EXISTS userDet;
DROP TABLE IF EXISTS company;
DROP TABLE IF EXISTS comBase;
DROP TABLE IF EXISTS comDet;

CREATE TABLE USER(
id INT PRIMARY KEY AUTO_INCREMENT,
NAME VARCHAR(255) NOT NULL,
idCard VARCHAR(255) NOT NULL,
loginName VARCHAR(255) NOT NULL,
PASSWORD VARCHAR(255) NOT NULL,
phone VARCHAR(255) NOT NULL
);

CREATE TABLE userDet(
userid INT NOT NULL PRIMARY KEY,
house VARCHAR(255),
liveTime VARCHAR(255),
occupation VARCHAR(255),
workTime VARCHAR(255),
credit VARCHAR(255),
backCount VARCHAR(255),
debt VARCHAR(255),
selectTime VARCHAR(255),
creditTime VARCHAR(255),
outCount VARCHAR(255),
creditUse VARCHAR(255),
creditBreak VARCHAR(255),
mask VARCHAR(255)
);

CREATE TABLE company(
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
cname VARCHAR(255),
loginName VARCHAR(255),
cpassword VARCHAR(255)
);

CREATE TABLE comBase(
id INT PRIMARY KEY,
cname VARCHAR(255),
ename VARCHAR(255),
raddress VARCHAR(255),
maddress VARCHAR(255),
marea VARCHAR(255),
csxz VARCHAR(255),
phone VARCHAR(255),
cz VARCHAR(255),
yb VARCHAR(255),
wadd VARCHAR(255),
ctype VARCHAR(255),
zch VARCHAR(255),
zctime VARCHAR(255),
dkk VARCHAR(255),
zzjgdm VARCHAR(255)
);

CREATE TABLE comDet(
comid VARCHAR(255) PRIMARY KEY,
lxtime VARCHAR(255),
zczb VARCHAR(255),
zcze VARCHAR(255),
jycd VARCHAR(255),
zjlglgwnx VARCHAR(255),
zjlxl VARCHAR(255),
ygxljg VARCHAR(255),
zscqsl VARCHAR(255),
ppjz VARCHAR(255),
jgszhlx VARCHAR(255),
zlrzgltx VARCHAR(255),
fwwd VARCHAR(255),
rlzygl VARCHAR(255),
rykh VARCHAR(255),
zzddpx VARCHAR(255),
khglzd VARCHAR(255),
htgl VARCHAR(255),
cwglzd VARCHAR(255),
zcfzl VARCHAR(255),
ldbl VARCHAR(255),
sdbl VARCHAR(255),
zcjll VARCHAR(255),
jzcsyl VARCHAR(255),
xsjll VARCHAR(255),
xsezzl VARCHAR(255),
zzczzl VARCHAR(255),
jzczzl VARCHAR(255),
jlrzzl VARCHAR(255),
xjllczl VARCHAR(255),
xjldfzbl VARCHAR(255),
sszcjl VARCHAR(255),
gabljl VARCHAR(255),
fzrjj VARCHAR(255),
fzrwf VARCHAR(255),
qyry VARCHAR(255),
qywzzl VARCHAR(255),
dzswjy VARCHAR(255),
qyglrj VARCHAR(255),
mask VARCHAR(255)
);