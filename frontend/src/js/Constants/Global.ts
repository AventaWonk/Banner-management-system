export enum Order {
    ASCENDING = 1,
    DESCENDIN = -1
}

export const DEFAULT_SORTING_ORDER = Order.ASCENDING;

export const BANNERS_TABLE_ROWS = [
{
    title: 'Id',
    key: 'id'
},
{
    title: 'Image source',
    key: 'imgSrc'
},
{
    title: 'Width',
    key: 'width'
},
{
    title: 'Height',
    key: 'height'
},
{
    title: 'Target URL',
    key: 'targetUrl'
},
{
    title: 'Language Id',
    key: 'langId'
},
];