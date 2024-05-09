import { ArrowRightCircleIcon } from "@heroicons/react/24/solid";

export default function HeaderComponent() {
  return (
    <section className="bg-[#0135BA]">
      <div className="flex">
        <h1 className="p-4 uppercase">Depen</h1>
        <div className="flex w-full justify-center">
          <button className="py-2 px-4 uppercase">Inicio</button>
          <button className="py-2 px-4 uppercase">Contato</button>
          <button className="py-2 px-4 uppercase">Documentos</button>
          <button className="py-2 px-4 uppercase">Sobre</button>
        </div>
        <div className="flex px-2 items-center justify-end">
          <button className="flex items-center shadow-lg justify-center p-4 bg-[#1348D0] rounded-md w-[177px] h-[39px]">
            <strong className="uppercase mr-10">Entrar</strong>
            <ArrowRightCircleIcon className="h-8 w-8" />
          </button>
        </div>
      </div>
    </section>
  );
}
