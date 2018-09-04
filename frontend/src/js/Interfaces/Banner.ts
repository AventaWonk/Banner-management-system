export default interface Banner {
    id: number | null | undefined;
    imgSrc: string;
    width: number;
    height: number;
    targetUrl: string;
    langId: number;
}