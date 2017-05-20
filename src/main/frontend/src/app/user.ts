export class User {
  constructor(
    public id: number,
    public roleId:number,
    public firstName: string,
    public lastName: string,
    public userName: string,
    public email: string,
    public password:string
  ){}
}
